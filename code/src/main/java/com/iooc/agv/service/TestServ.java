package com.iooc.agv.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iooc.agv.model.Person;

@Controller   
@RequestMapping("/mvc")
public class TestServ {
//	, produces = { "application/xml", "application/json" }
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public @ResponseBody String hello() {
		Person p = new Person("wgx",12);
		return "hxj";
	}

	@RequestMapping(value = "/hello2")
	public String hello2() {
		return "wgx";
	}
}
