package com.app.mybatis.plugins.pagable.dialects;

import com.app.mybatis.plugins.pagable.Dialect;

public class MysqlDialect implements Dialect {

	@Override
	public String buildPaginationSql(String originalSql, int offset, int length) {
		StringBuilder paginationSql = new StringBuilder(originalSql);
		paginationSql.insert(0, "select * from (").append(") as _t limit ");  
		paginationSql.append(offset-1);  
		paginationSql.append(",");  
		paginationSql.append(length); 
		return paginationSql.toString();
	}

}
