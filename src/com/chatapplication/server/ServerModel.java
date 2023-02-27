package com.chatapplication.server;

import com.chatapplication.socket.ServerSideSocket;

public class ServerModel implements ServerModelCallBack {
	private ServerModelControllerCallBack serverController;
	private ServerSideSocket serverSideSocketInstance = ServerSideSocket.getInstance();
	public ServerModel(ServerController serverController) {
		this.serverController = serverController;
	}
	@Override
	public boolean isClientActive() {
		return serverSideSocketInstance.isClientActive();
	}
	@Override
	public String readFromClient() {
		return serverSideSocketInstance.readUTF();
	}
	@Override
	public void writeToClient(String s2) {
		serverSideSocketInstance.writeUTF(s2);
	}
}
