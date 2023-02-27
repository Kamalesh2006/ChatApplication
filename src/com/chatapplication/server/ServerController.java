package com.chatapplication.server;

public class ServerController implements ServerControllerCallBack, ServerModelControllerCallBack {
	private ServerViewCallBack serverView;
	private ServerModelCallBack serverModel;
	public ServerController(ServerView serverView) {
		this.serverView = serverView;
		this.serverModel = new ServerModel(this);
	}
	@Override
	public boolean isClientActive() {
		return serverModel.isClientActive();
	}
	@Override
	public String readFromClient() {
		return serverModel.readFromClient();
	}
	@Override
	public void writeToClient(String s2) {
		serverModel.writeToClient(s2);
	}

}
