package com.app.demo.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.app.demo.model.User;
import com.app.mybatis.plugins.pagable.Pagination;

public interface UserMapper {
	@Select("SELECT * FROM USER as u WHERE u.id = #{userId}")
	User getUser(@Param("userId") long id);
	
	@Select("SELECT * FROM USER as u")
	Pagination<User> getAllUser(Pagination<User> param);
}
