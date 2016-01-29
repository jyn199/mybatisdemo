package com.app.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.app.demo.dao.interfaces.UserDao;
import com.app.demo.model.User;

@Controller
@Scope(value="prototype")
@RequestMapping("/")
@SessionAttributes({"demo"})
public class AppController {

	@RequestMapping(value = "app")
	public ModelAndView appIndex(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/app/index");
		return mav;
	}

	@RequestMapping(value = "")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/index");
		return mav;
	}
	
	@RequestMapping(value = "getUser")
	public ModelAndView getUser(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/app/user");
		
		WebApplicationContext c = (WebApplicationContext)request.getSession().getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		UserDao dao = (UserDao)c.getBean("userDaoImpl");
		User u = dao.getUserById(1);
		if(u == null){
			mav.addObject("username", null);
		}else{
			mav.addObject("username", u.getName());
		}
		return mav;
	}

}
