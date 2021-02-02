package TP1.Q6;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

//Q3
public class Server {

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(2500);
            Socket s = ss.accept();// establishes connection
            while (true) {
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();
                System.out.println(str);
                int taille = str.length();
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                dout.write(taille);
                dout.flush();
                if (str.equals("QUITTER")) {
                    ss.close();
                }

            }
        } catch (IOException ex) {
            System.out.println("exit");
        }

    }
}
