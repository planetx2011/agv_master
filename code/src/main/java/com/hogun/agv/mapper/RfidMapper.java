package com.hogun.agv.mapper;

import com.hogun.agv.model.RfidInfo;

public interface RfidMapper {
	boolean insertRfid(RfidInfo rfidInfo);
	
	RfidInfo selectOneRfid(Integer rfidNo);
}
