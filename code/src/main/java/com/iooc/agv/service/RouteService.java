package com.iooc.agv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iooc.agv.model.Coordinate;
import com.iooc.agv.model.RouteInfo;

@Controller
@RequestMapping("/route")
public class RouteService {

	@RequestMapping(value = "/getRoute", method = RequestMethod.GET)
	public @ResponseBody RouteInfo getRoute() {
		RouteInfo route = new RouteInfo();
		List<Coordinate> coordList = new ArrayList<>();
		coordList.add(new Coordinate(100,100));
		coordList.add(new Coordinate(100,600));
		coordList.add(new Coordinate(800,600));
		coordList.add(new Coordinate(800,350));
		coordList.add(new Coordinate(100,100));
		List<List<Coordinate>> routeList = new ArrayList<>();
		routeList.add(coordList);
		route.setRouteInfo(routeList);
		return route;
	}

}
