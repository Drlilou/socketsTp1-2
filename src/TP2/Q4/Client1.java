package TP1.Q4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//Q3
public class Client1 {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2017);
            Socket s = ss.accept();// establishes connection
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println(str);
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();// System.out.println(e);
        }
    }
}
