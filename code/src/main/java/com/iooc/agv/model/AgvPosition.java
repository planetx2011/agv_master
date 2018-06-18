package com.iooc.agv.model;

public class AgvPosition {
	private int id;
	private Coordinate coordinate;
	private int offset;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

}
