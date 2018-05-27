package com.iooc.agv.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Communications implements Runnable {

	Socket client = null;

	public Communications(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			// PrintStream bufSend = new PrintStream(this.client.getOutputStream());
			BufferedReader bufRecv = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
			boolean flag = true;
			while (flag) {
				String str = bufRecv.readLine();
				// 数据校验
				if (!crcMsg(str)) {
					continue;
				}

				// 消息解析
				decodeMsg(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void decodeMsg(String strMsg) {

	}
	
	private boolean crcMsg(String str) {
		if (str == null || str.isEmpty()) {
			System.out.println("no data");
			return false;
		}

		// TODO 完成CRC校验代码
		return true;
	}
}
