package TP1.Q7;

import TP1.Q5.*;
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
            while (true) {
                Socket s = ss.accept();// establishes connection

                new EchoThread(s).start();
            }
        } catch (IOException ex) {
            System.out.println("exit");
        }

    }
}
