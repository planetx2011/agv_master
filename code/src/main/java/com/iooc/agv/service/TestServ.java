package com.iooc.agv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iooc.agv.mapper.UserMapper;
import com.iooc.agv.model.Person;
import com.iooc.agv.util.JsonUtil;

@Controller
@RequestMapping("/mvc")
public class TestServ {
	// , produces = { "application/xml", "application/json" }
	@Autowired
	private UserMapper userDao;

	public void setUserDao(UserMapper userDao) {
		this.userDao = userDao;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public @ResponseBody String hello() {
		Person p = new Person("wgx", 12);
		return "hxj";
	}

	@RequestMapping(value = "/hello2")
	public @ResponseBody String hello2() {
		Object obj = userDao.selectAllUser();
		return "wgx" + JsonUtil.toJson(obj);
	}
}
