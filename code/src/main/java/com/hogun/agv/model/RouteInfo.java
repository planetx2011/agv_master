package com.hogun.agv.model;

import java.util.List;

public class RouteInfo {
	private List<List<Coordinate>> routeInfo;

	public List<List<Coordinate>> getRouteInfo() {
		return routeInfo;
	}

	public void setRouteInfo(List<List<Coordinate>> routeInfo) {
		this.routeInfo = routeInfo;
	}

}
