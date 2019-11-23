package com.hogun.agv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hogun.agv.mapper.UserMapper;
import com.hogun.agv.model.User;

@Controller
@RequestMapping("/login")
public class CommonService {
	@Autowired
	private UserMapper userDao;

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public @ResponseBody Object checkOutUser(@RequestParam("userName") String userName, @RequestParam("password")String password) {
		List<User> userList = userDao.selectAllUser();
		return userList.stream().filter(item -> !StringUtils.isEmpty(userName)
				&& userName.equals(item.getUserName())).count() != 0;
	}
}
