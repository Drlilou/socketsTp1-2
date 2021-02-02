package TP1.Q4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 2500);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Hello world.");
			dout.flush();
			DataInputStream din=new DataInputStream(s.getInputStream());  
			int taille=din.read(); 
			System.out.println(taille);
			din.close();
                        dout.close();
			
			s.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
