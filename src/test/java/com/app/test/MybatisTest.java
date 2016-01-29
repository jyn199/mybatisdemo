package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.demo.dao.mapper.UserMapper;
import com.app.demo.model.User;

public class MybatisTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationSpringApp.xml");
		UserMapper mapper = context.getBean(UserMapper.class);
		User user = mapper.getUser(123);
		System.out.println("ID为：" + 123 + "的用户为：" + user);
	}
}
