package com.hogun.agv.connection;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.hogun.agv.util.Constants;

public class Communications implements Runnable {

	Socket client = null;

	public Communications(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			InputStream bufRecv = this.client.getInputStream();
			while (client.isConnected()) {
				int nextByte = -1;
				// 报文示例：FD 0D 00 01 0F 31 02 05 02 03 00 20 10 00 00 AB AB CC CC
				ArrayList<Byte> lstBye = new ArrayList<Byte>();
				while ((nextByte = bufRecv.read()) != -1) {
					byte curByte = (byte) ((byte) nextByte & 0xFF);
					lstBye.add(curByte);
					if (lstBye.size() == Constants.MESSAGE_BYTE_SIZE) {
						
						MessageCache.getSingleton().addMsg(lstBye);
					}

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
