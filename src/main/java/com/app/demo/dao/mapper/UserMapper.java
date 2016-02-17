package com.app.demo.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.app.demo.model.User;
import com.app.mybatis.plugins.pagable.Pagination;

public interface UserMapper {
	@Select("SELECT * FROM DEMO_TEST WHERE id = #{userId}")
	User getUser(@Param("userId") long id);
	
	@Select("SELECT * FROM DEMO_TEST")
	Pagination<User> getAllUser(Pagination<User> param);
}
