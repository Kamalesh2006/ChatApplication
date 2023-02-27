package com.chatapplication.server;

import java.util.Scanner;

public class ServerView implements ServerViewCallBack{
	private Scanner scanner = new Scanner(System.in);
	private ServerControllerCallBack serverController;
	public ServerView() {
		this.serverController = new ServerController(this);
	}
	//this is the first page the server will see
	public void serverPage() {
		if(serverController.isClientActive()) {
			//server socket is receiving sockets
			System.out.println("Server and client connected");
			while(true) {
				String s1 = serverController.readFromClient();
				System.out.println("Client Says: "+s1);
				String s2 = scanner.nextLine();
				serverController.writeToClient(s2);
				if(s1.equals("exit")) {
					System.out.println("Thank you for using");
					break;
				}
			}
		}
	}
}
