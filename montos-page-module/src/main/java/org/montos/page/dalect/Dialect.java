package org.montos.page.dalect;

/**
 * @author Montos
 * @create 2021/5/7 2:52 下午
 */
public interface Dialect {
    /**
     * 获取count SQL语句
     *
     * @param targetSql
     * @return
     */
    default String getCountSql(String targetSql) {
        return String.format("select count(1) from (%s) tmp_count", targetSql);
    }

    /**
     * 获取limit SQL语句
     * @param targetSql
     * @param offset
     * @param limit
     * @return
     */
    String getLimitSql(String targetSql, int offset, int limit);
}
