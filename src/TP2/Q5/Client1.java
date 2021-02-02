package TP1.Q5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//Q3
public class Client1 {

    public static void main(String[] args) throws IOException {
        int PORT = 2017;
        String QUIT = "QUIT";
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket accept = serverSocket.accept();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
                String message = null;

                while ((message = bufferedReader.readLine()) != null) {
                    System.out.println("client : :" + message);
                    bufferedWriter.write(message + "\n");
                    bufferedWriter.flush();
                    if (QUIT.equals(message)) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
