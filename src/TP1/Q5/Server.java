package TP1.Q5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//Q3
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2500);
            Socket s = ss.accept();// establishes connection
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println(str);
            int taille = str.length();
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.write(taille);
            dout.flush();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();// System.out.println(e);
        }
    }
}
