package com.iooc.agv.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.iooc.agv.mapper.UserMapper;
import com.iooc.agv.model.User;


@Controller
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserMapper userDao;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// #TOOD# password need encrypted and can't be compared directed
		List<User> userList = userDao.selectAllUser();
		if (userList.stream().filter(item -> userName.equals(item.getUserName()) && password.equals(item.getPassword()))
				.count() == 0) {
			return;
		}
		System.out.println(userName + password);
		this.doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return;
	}

}
