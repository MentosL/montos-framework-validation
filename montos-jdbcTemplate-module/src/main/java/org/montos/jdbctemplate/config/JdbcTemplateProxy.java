package org.montos.jdbctemplate.config;

/**
 * @author Montos
 * @create 2021/4/22 5:13 下午
 */

import java.lang.reflect.Method;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.freestyle.common.hibernate.dao.support.SqlLogger;
/****
 * JdbcTemplate&NamedParameterJdbcTemplate的代理,增加了输出带参数值的SQL日志,方便调试
 * @author dgmislrh
 *
 */

public class JdbcTemplateProxy implements MethodInterceptor {
    private Class<?> targetClass;
    protected final Log logger = LogFactory.getLog(TransJdbcTemplate.class.getClass());

    // 相当于JDK动态代理中的绑定
    public <T> T getInstance(Class<T> targetClass) {
        this.targetClass = targetClass;
        Enhancer enhancer = new Enhancer(); // 创建加强器，用来创建动态代理类
        enhancer.setSuperclass(targetClass); // 为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        // 设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
        enhancer.setCallback(this);
        // 创建动态代理类对象并返回
        return (T) enhancer.create();
    }

    // 相当于JDK动态代理中的绑定
    public <T> T getInstance(Class<T> targetClass, Class[] pvClasses, Object[] pvArgs) {
        this.targetClass = targetClass;
        Enhancer enhancer = new Enhancer(); // 创建加强器，用来创建动态代理类
        enhancer.setSuperclass(targetClass); // 为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        // 设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
        enhancer.setCallback(this);
        // 创建动态代理类对象并返回
        return (T) enhancer.create(pvClasses, pvArgs);
    }

    // 实现回调方法
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // System.out.println("预处理——————");
        String lvsMethodName = method.getName();
        if (logger.isInfoEnabled() && ((targetClass==JdbcTemplate.class &&(lvsMethodName.equals("query") || lvsMethodName.equals("execute"))
                && args.length > 0 && args[0] instanceof String)||
                targetClass==NamedParameterJdbcTemplate.class&&(lvsMethodName.equals("queryForObject") || lvsMethodName.equals("execute")
                        ||lvsMethodName.equals("queryForList")))) {
            Object[] methodArgs = args, sqlArgs = null;
            Map<String, Object> sqlArgsM = null;

            // get the SQL statement
            String statement = methodArgs[0].toString();
            boolean lvbSkip=false;
            // find the SQL arguments (parameters)
            for (int i = 1, n = methodArgs.length; i < n; i++) {
                Object arg = methodArgs[i];
                if (targetClass == JdbcTemplate.class) {
                    if (arg instanceof Object[]) {
                        sqlArgs = (Object[]) arg;
                        break;
                    }
                    if ( arg instanceof ArgumentPreparedStatementSetter){
                        lvbSkip=true;
                        break;
                    }
                } else {

                    if (arg instanceof Map) {
                        sqlArgsM = (Map<String, Object>) arg;
                        break;
                    }
                    if ( arg instanceof MapSqlParameterSource){
                        lvbSkip=true;
                        break;
                    }
                }

            }
            if (targetClass==JdbcTemplate.class && args.length>=2 && args[1] instanceof ColumnMapRowMapper){
                lvbSkip=true;
            }
            if (!lvbSkip){
                String completedStatement = targetClass == JdbcTemplate.class ?(sqlArgs == null ? statement
                        :  SqlLogger.fillParameters(statement, sqlArgs))
                        :(sqlArgsM==null?statement: SqlLogger.fillNamedParameters(statement, sqlArgsM));
                // log it
                logger.info(targetClass.getSimpleName() + "." + lvsMethodName + "\n------FULL SQL------\n"
                        + completedStatement + "\n---------------------");
            }
        }
        // proxy.invokeSuper(obj, args); //调用业务类（父类中）的方法
        // return method.invoke(target, args);
        return proxy.invokeSuper(obj, args); // 调用业务类（父类中）的方法
        // System.out.println("调用后操作——————");
    }
}
