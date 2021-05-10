package org.montos.page.dalect;

import org.springframework.stereotype.Component;

/**
 * @author Montos
 * @create 2021/5/7 2:57 下午
 */
@Component
public class MysqlDialect implements Dialect{

    private static final String PATTERN = "%s limit %s, %s";

    private static final String PATTERN_FIRST = "%s limit %s";

    @Override
    public String getLimitSql(String targetSql, int offset, int limit) {
        if (offset == 0) {
            return String.format(PATTERN_FIRST, targetSql, limit);
        }
        return String.format(PATTERN, targetSql, offset, limit);
    }
}
