package com.iooc.agv.mapper;

import com.iooc.agv.model.RfidInfo;

public interface RfidMapper {
	boolean insertRfid(RfidInfo rfidInfo);
	
	RfidInfo selectOneRfid(Integer rfidNo);
}
