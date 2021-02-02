/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1.Q6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ITDR
 */
class Client1 extends Thread {

    Socket serverClient;
    // int clientNo;

    Client1(Socket inSocket) {
        serverClient = inSocket;
        //     clientNo = counter;
    }

    @Override
    public void run() {
        try {
            DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
            //DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
            String clientMessage = "";//, serverMessage = "";
            while (!clientMessage.equals("quit")) {
                clientMessage = inStream.readUTF();
                System.out.println(clientMessage);
                // serverMessage = "From Server to Client " + clientNo + " Text : " + clientMessage;
                // outStream.writeUTF(serverMessage);
                //outStream.flush();
            }
            inStream.close();
            //   outStream.close();
            serverClient.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    void rec() {
        start();
    }

    public static void main(String[] args) throws Exception {
        try {
            ServerSocket server = new ServerSocket(2017);
            System.out.println("Server Started ....");
            while (true) {
                Socket serverClient = server.accept();  //server accept the client connection request
                Client1 sct = new Client1(serverClient); //send  the request to a separate thread
                sct.rec();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
