package org.montos.jdbctemplate.config;

/**
 * @author Montos
 * @create 2021/4/22 5:17 下午
 */

import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.montos.jdbctemplate.util.Util;

/*****
 * SQL日志打印工具,可将jdbctemplate的参数值一起显示(依赖spring环境)
 * @author dgmislrh
 * 14/May/2018
 */
@Aspect
public class SqlLogger {
    private static final Logger log = Logger.getLogger(SqlLogger.class);

    @Before("execution(* org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate.*(..))")
    public void logNamedJdbcTemplate(JoinPoint jp) throws Throwable {
        Object[] methodArgs = jp.getArgs();
        Map<String,Object> sqlArgs = null;

        // get the SQL statement
        String statement = methodArgs[0].toString();

        // find the SQL arguments (parameters)
        for (int i = 1, n = methodArgs.length; i < n; i++) {
            Object arg = methodArgs[i];
            if (arg instanceof Map) {
                sqlArgs = (Map<String,Object>)arg;
                break;
            }
        }
        // fill in any SQL parameter place-holders (?'s)
        String completedStatement = (sqlArgs == null ? statement : fillNamedParameters(statement, sqlArgs));

        // log it
        log.debug(jp.getSignature().toShortString()+ "\n------FULL SQL------\n"+completedStatement+"\n---------------------");
    }
    private String fillNamedParameters(String statement,Map<String,Object> sqlArgs){
        StringBuilder sb=new StringBuilder(statement);
        for (Entry<String, Object>item:sqlArgs.entrySet()){
            int lvnSeek=sb.indexOf(":"+item.getKey());
            if (lvnSeek==-1)continue;
            String lvsValue=null;
            if (item.getValue()==null){
                lvsValue="null";
            }
            else if (item.getValue() instanceof String){
                lvsValue=String.format("'%s'", item.getValue());
            }
            else if (item.getValue() instanceof Boolean){
                lvsValue=((Boolean) item.getValue()).booleanValue()?"true":"false";
            }
            else if (item.getValue() instanceof java.util.Date){
                java.util.Date lvdDt=(java.util.Date) item.getValue();
                if (lvdDt.getHours()==0&&lvdDt.getMinutes()==0&& lvdDt.getSeconds()==0){
                    lvsValue="timestamp '"+ Util.datetimeToString((java.util.Date)item.getValue(),Util.c_java_datefmt)+"'";
                }
                else{
                    lvsValue="timestamp '"+Util.datetimeToString((java.util.Date)item.getValue(),Util.c_java_dttfmt)+"'";
                }
            }
            else {
                lvsValue=item.getValue().toString();
            }
            sb.replace(lvnSeek, lvnSeek+item.getKey().length()+1, lvsValue);
        }
        return sb.toString();
    }
    @Before("execution(* org.springframework.jdbc.core.JdbcOperations.*(..))")
    //@Before("execution(* org.springframework.jdbc.core.namedparam.*(..))")
    public void logJdbcTemplate(JoinPoint jp) throws Throwable {
        Object[] methodArgs = jp.getArgs(),
                sqlArgs = null;

        // get the SQL statement
        String statement = methodArgs[0].toString();

        // find the SQL arguments (parameters)
        for (int i = 1, n = methodArgs.length; i < n; i++) {
            Object arg = methodArgs[i];
            if (arg instanceof Object[]) {
                sqlArgs = (Object[])arg;
                break;
            }
        }
        // fill in any SQL parameter place-holders (?'s)
        String completedStatement = (sqlArgs == null ? statement : fillParameters(statement, sqlArgs));

        // log it
        log.debug(jp.getSignature().toShortString()+"\n------FULL SQL------\n"+completedStatement+"\n---------------------");
    }


    private String fillParameters(String statement, Object[] sqlArgs) {
        // initialize a StringBuilder with a guesstimated final length
        StringBuilder completedSqlBuilder = new StringBuilder(Math.round(statement.length() * 1.2f));
        int index, // will hold the index of the next ?
                prevIndex = 0; // will hold the index of the previous ? + 1

        // loop through each SQL argument
        for (Object arg : sqlArgs) {
            index = statement.indexOf("?", prevIndex);
            if (index == -1)
                break; // bail out if there's a mismatch in # of args vs. ?'s

            // append the chunk of SQL coming before this ?
            completedSqlBuilder.append(statement.substring(prevIndex, index));
            if (arg == null)
                completedSqlBuilder.append("null");
            else if (arg instanceof String) {
                // wrap the String in quotes and escape any quotes within
                completedSqlBuilder.append('\'')
                        .append(arg.toString().replace("'", "''"))
                        .append('\'');
            }
            else if (arg instanceof java.sql.Date) {
                java.util.Date lvdDt=new java.sql.Date(((java.sql.Date)arg).getTime());
                String lvsValue="timestamp '"+Util.datetimeToString(lvdDt,Util.c_java_dttfmt)+"'";
                completedSqlBuilder.append(lvsValue);
            }
            else
                completedSqlBuilder.append(arg.toString());

            prevIndex = index + 1;
        }

        // add the rest of the SQL if any
        if (prevIndex != statement.length())
            completedSqlBuilder.append(statement.substring(prevIndex));

        return completedSqlBuilder.toString();
    }
}
