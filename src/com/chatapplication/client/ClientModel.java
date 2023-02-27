package com.chatapplication.client;

import com.chatapplication.socket.ClientSocket;

public class ClientModel implements ClientModelCallBack {
	private ClientControllerModelCallBack clientController;
	private ClientSocket clientSocket = ClientSocket.getInstance();
	public ClientModel(ClientController clientController) {
		this.clientController = clientController;
	}
	@Override
	public void writeToServer(String s1) {
		clientSocket.writeUTF(s1);
	}
	@Override
	public String readFromServer() {
		return clientSocket.readUTF();
	}

}
