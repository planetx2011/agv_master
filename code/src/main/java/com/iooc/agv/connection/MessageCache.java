package com.iooc.agv.connection;

import java.util.ArrayList;

import com.iooc.agv.util.Constants;

public class MessageCache {
	private volatile static MessageCache singleton;

	private ArrayList<ArrayList<Byte>> _msg = new ArrayList<ArrayList<Byte>>();
	private MessageCache() {
	}

	public static MessageCache getSingleton() {
		if (singleton == null) {
			synchronized (MessageCache.class) {
				if (singleton == null) {
					singleton = new MessageCache();
				}
			}
		}
		return singleton;
	}
	
	public synchronized void addMsg(ArrayList<Byte> array) {
		printRecvByte(array);
		_msg.add(array);
		getMsg();
	}
	
	private void printRecvByte(ArrayList<Byte> bytes) {
		for (Byte byte1 : bytes) {
			String temp = Integer.toHexString((byte)byte1 & 0xFF).toUpperCase(); 
			if (temp.length() == 1) {
				temp = "0" + temp;
			}
			
			System.out.print(temp); 
		}
	}
	
	private synchronized void saveDb() {
		// TODO
	}
	public synchronized boolean getMsg() {
		if (_msg.isEmpty()) {
			return false;
		}
		
		ArrayList<Byte> oneMsg = _msg.get(0);
		if (oneMsg.size() != Constants.MESSAGE_BYTE_SIZE) {
			return false;
		}
		
		Byte cmdFlag = oneMsg.get(5);
		if (cmdFlag == 0x31) {
			System.out.println("get message from AGV, and command is 0x31");
		}
		return false;
	}
}