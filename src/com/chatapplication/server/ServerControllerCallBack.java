package com.chatapplication.server;

public interface ServerControllerCallBack {

	boolean isClientActive();

	String readFromClient();

	void writeToClient(String s2);

}
