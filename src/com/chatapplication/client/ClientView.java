package com.chatapplication.client;

import java.util.Scanner;

public class ClientView implements ClientViewCallBack {
	private ClientControllerCallBack clientController;
	private Scanner scanner = new Scanner(System.in);
	public ClientView() {
		this.clientController = new ClientController(this);
	}
	//this is the first after starting the application from the client side
	public void clientPage() {
		System.out.println("Welcome to chat application (Client)");	
		String s1 ="",s2 ="";
		while(true) {
			s1 = scanner.nextLine();
			clientController.writeToServer(s1);
			s2 = clientController.readFromServer();
			System.out.println("Server says: "+s2);
			if(s1.equals("exit")) {
				System.out.println("Thanks for chatting");
				break;
			}
		}
	}
}
