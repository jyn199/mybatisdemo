package com.app.demo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.demo.dao.interfaces.UserDao;
import com.app.demo.dao.mapper.UserMapper;
import com.app.demo.model.User;

@Service
public class UserDaoImpl implements UserDao {
	
	@Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) { 
        this.userMapper = userMapper; 
    } 

    public User getUserById(long id) {
       return userMapper.getUser(id); 
    }
}
