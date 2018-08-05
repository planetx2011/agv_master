package com.iooc.agv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iooc.agv.model.AgvPosition;
import com.iooc.agv.model.AgvState;
import com.iooc.agv.model.Coordinate;
@Controller
@RequestMapping("/state")
public class AgvStateService {
	@RequestMapping(value = "/getAgvPosition", method = RequestMethod.GET)
	public @ResponseBody List<AgvPosition> getAgvPosition() {
		List<AgvPosition> list = new ArrayList<>();
		AgvPosition agv = new AgvPosition();
		agv.setId(1);
		agv.setOffset(100);
		agv.setCoordinate(new Coordinate(100, 100));
		list.add(agv);
		return list;
	}
	
	public @ResponseBody List<AgvState> getAgvRunState() {
		return null;
	}
}
