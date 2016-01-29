package com.app.mybatis.plugins.pagable;

public interface Dialect {

	String buildPaginationSql(String originalSql, int offset, int length);

}
