package com.iooc.agv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iooc.agv.mapper.UserMapper;
import com.iooc.agv.model.User;

@Controller
@RequestMapping("/login")
public class CommonService {
	@Autowired
	private UserMapper userDao;

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public @ResponseBody Object checkOutUser(@RequestParam("userName") String userName, @RequestParam("password")String password) {
		List<User> userList = userDao.selectAllUser();
		// ModelAndView modelAndView=new ModelAndView();
		// modelAndView.setViewName("/WEB-INF/jsp/test.jsp");//重定向为"redirect:url路径"
		return userList.stream().filter(item -> !StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password)
				&& userName.equals(item.getUserName()) && password.equals(item.getPassword())).count() != 0;
	}
}
