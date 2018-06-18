package com.iooc.agv.model;

public class AgvState {
	private int id;
	
	private int error;
	
	private int runningStatus;
	
	private int direct;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public int getRunningStatus() {
		return runningStatus;
	}

	public void setRunningStatus(int runningStatus) {
		this.runningStatus = runningStatus;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}
	
	
}
