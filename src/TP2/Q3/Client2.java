package TP1.Q3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 2017);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            dout.writeUTF(str);
            dout.flush();
            
            dout.close();

            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
