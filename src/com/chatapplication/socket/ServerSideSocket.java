package com.chatapplication.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSideSocket {
	private static ServerSideSocket serverSideSocket;
	private ServerSocket serverSocket = null;
	private DataInputStream din = null;
	private DataOutputStream dout = null;
	private Socket socket = null;

	private ServerSideSocket() {
		// initializing serversocket connection
		init();
	}

	private void init() {
		try {
			serverSocket = new ServerSocket(1234);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ServerSideSocket getInstance() {
		if(serverSideSocket ==null) {
			serverSideSocket = new ServerSideSocket();
		}
		return serverSideSocket;
	}

	public boolean isClientActive() {
		try {
			socket = serverSocket.accept();
			din = new DataInputStream(socket.getInputStream());
	        dout = new DataOutputStream(socket.getOutputStream());
			return true;
		} catch (IOException e) {
			return false;
		}
		
	}

	public String readUTF() {
		try {
			return din.readUTF();
		} catch (IOException e) {
			return null;
		}
	}

	public void writeUTF(String s2) {
		try {
			dout.writeUTF(s2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
