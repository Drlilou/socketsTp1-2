package TP1.Q1;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(2500);
			Socket s = ss.accept();// establishes connection
		
		} catch (Exception e) {
			e.printStackTrace();// System.out.println(e);
		}
	}
}
