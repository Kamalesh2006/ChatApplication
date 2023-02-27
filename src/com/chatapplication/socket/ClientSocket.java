package com.chatapplication.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocket {
	private static ClientSocket clientSocket;
	private DataInputStream din = null;
	private DataOutputStream dout = null;
	private Socket socket = null;

	private ClientSocket() {
		// creating socket connection
		init();
	}

	public static ClientSocket getInstance() {
		if (clientSocket == null) {
			clientSocket = new ClientSocket();
		}
		return clientSocket;
	}

	private void init() {
		try {
			socket = new Socket("localhost", 1234);
			din = new DataInputStream(socket.getInputStream());
			dout = new DataOutputStream(socket.getOutputStream());
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public void writeUTF(String s1) {
		try {
			dout.writeUTF(s1);
			dout.flush();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public String readUTF() {
		try {
			String s2 = din.readUTF();
			return s2;
		} catch (IOException io) {
			return null;
		}
	}
}
