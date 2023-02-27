package com.chatapplication.client;

public class ClientController implements ClientControllerCallBack, ClientControllerModelCallBack {
	private ClientViewCallBack clientView;
	private ClientModelCallBack clientModel;
	public ClientController(ClientView clientView) {
		this.clientView = clientView;
		this.clientModel = new ClientModel(this);
	}
	@Override
	public void writeToServer(String s1) {
		clientModel.writeToServer(s1);
	}
	@Override
	public String readFromServer() {
		return clientModel.readFromServer();
	}

}
