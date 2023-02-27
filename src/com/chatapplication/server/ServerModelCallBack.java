package com.chatapplication.server;

public interface ServerModelCallBack {

	boolean isClientActive();

	String readFromClient();

	void writeToClient(String s2);

}
