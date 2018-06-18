package com.iooc.agv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iooc.agv.mapper.RfidMapper;
import com.iooc.agv.model.RfidInfo;

@Controller
@RequestMapping("/rfid")
public class RfidService {
	@Autowired
	private RfidMapper rfidDao;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody String addRfid(@RequestParam("rfidnum") Integer rfidNo, @RequestParam("rfidX") Integer rfidX, @RequestParam("rfidY") Integer rfidY) {
		RfidInfo oldRfid = rfidDao.selectOneRfid(rfidNo);
		if (oldRfid != null) {
			return "Error String";
		}
		RfidInfo rfidInfo = new RfidInfo();
		rfidInfo.setRfidNo(rfidNo);
		rfidInfo.setRfidX(rfidX);
		rfidInfo.setRfidY(rfidY);
		
		if (rfidDao.insertRfid(rfidInfo)) {
			RfidInfo newRfid = rfidDao.selectOneRfid(rfidNo);
			if (newRfid != null) {
				return "true " + newRfid.getRfidNo();
			}
			return "false " + rfidNo;
		}
		return "Fail to insert rfid info";
	}
	
	@RequestMapping(value = "/getRfid", method = RequestMethod.GET)
	public @ResponseBody RfidInfo getRfid(@RequestParam("rfidnum") Integer rfidNo) {
		RfidInfo oldRfid = rfidDao.selectOneRfid(rfidNo);
		if (oldRfid != null) {
			return oldRfid;
		}
		return null;
	}
}
