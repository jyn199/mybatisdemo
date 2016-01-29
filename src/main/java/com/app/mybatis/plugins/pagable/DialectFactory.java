package com.app.mybatis.plugins.pagable;

import com.app.mybatis.plugins.pagable.dialects.MysqlDialect;
import com.app.mybatis.plugins.pagable.dialects.OracleDialect;

public class DialectFactory {

	public static Dialect getDialect(DialectType dialectType) {

		switch (dialectType) {
		case ORACLE:
			return new OracleDialect();
		case MYSQL:
			return new MysqlDialect();
		default:
			return new OracleDialect();
		}

	}
}
