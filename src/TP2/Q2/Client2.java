package TP1.Q2;

import java.io.DataOutputStream;
import java.net.Socket;

public class Client2 {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 2017);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Hello world.");
            dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
