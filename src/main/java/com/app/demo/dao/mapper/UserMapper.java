package com.app.demo.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.app.demo.model.User;

public interface UserMapper {
	@Select("SELECT * FROM user WHERE id = #{userId}")
	User getUser(@Param("userId") long id);
}
