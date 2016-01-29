package com.app.mybatis.plugins.pagable.dialects;

import com.app.mybatis.plugins.pagable.Dialect;

public class OracleDialect implements Dialect {

	@Override
	public String buildPaginationSql(String originalSql, int offset, int length) {
		StringBuilder paginationSql = new StringBuilder(originalSql);
		paginationSql.insert(0, "select t2.*, rownum rn from ( ")
				.append(" ) t2 where rownum < ").append(offset + length);
		paginationSql.insert(0, "select t1.* from ( ").append(" ) t1 where t1.rn >= ")
				.append(offset);
		return paginationSql.toString();
	}

}
