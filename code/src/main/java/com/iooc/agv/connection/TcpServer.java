package com.iooc.agv.connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 需要限制同时访问的TCP连接数量，避免消耗过多的CPU资源
public class TcpServer {

	private ServerSocket server;

	public void startServer() {
		try {
			server = new ServerSocket(9999);
			
			while (true) {
				Socket client = server.accept();
				System.out.println("success to connect client");
				new Thread(new Communications(client)).start();
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
