package TP1.Q5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) throws IOException {
        String HOST = "localhost";
        String QUIT = "QUIT";
        int PORT = 2017;
        Socket socket = null;
        try {
            socket = new Socket(HOST, PORT);
            boolean connected = socket.isConnected();
            if (connected) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bufferWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    String message = consoleReader.readLine();
                    bufferWriter.write(message + "\n");
                    bufferWriter.flush();
                    String serverMessage = bufferedReader.readLine();
                    System.out.println("  from Server :" + serverMessage);
                    if (QUIT.equalsIgnoreCase(serverMessage)) {
                        break;
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
