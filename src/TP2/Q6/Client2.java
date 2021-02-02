/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1.Q6;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ITDR
 */
public class Client2 extends Thread {

    Socket socket;

    public Client2() {
        try {
            socket = new Socket("127.0.0.1", 2017);
        } catch (IOException ex) {
            Logger.getLogger(Client2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String clientMessage = "";

            while (!clientMessage.equals("quit")) {

                System.out.println("Enter msg :");
                clientMessage = br.readLine();
                outStream.writeUTF(clientMessage);
                outStream.flush();

            }
            outStream.close();
            outStream.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void send() {
        start();
    }

    public static void main(String[] args) throws Exception {

        Client2 cl = new Client2();
        cl.send();
    }
}
