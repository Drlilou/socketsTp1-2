/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1.Q8;

import TP1.Q7.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 *
 * @author ITDR
 */
public class EchoThread extends Thread {

    protected Socket socket;

    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        InputStream inp = null;
        DataInputStream dis = null;
        DataOutputStream out = null;
        try {
            SocketAddress socketAddress = socket.getRemoteSocketAddress();

            if (socketAddress instanceof InetSocketAddress) {
                InetAddress inetAddress = ((InetSocketAddress) socketAddress).getAddress();
                if (inetAddress instanceof Inet4Address) {
                    System.out.println("IPv4: " + inetAddress);
                } else if (inetAddress instanceof Inet6Address) {
                    System.out.println("IPv6: " + inetAddress);
                } else {
                    System.err.println("Not an IP address.");
                }
            }
            dis = new DataInputStream(socket.getInputStream());

            //  brinp = new BufferedReader(new InputStreamReader(inp));
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        String line;
        while (true) {
            try {
                line = (String) dis.readUTF();
                System.out.println(line);
                if ((line == null) || line.equalsIgnoreCase("QUITTER")) {
                    socket.close();

                    return;
                } else {

                    out.write(line.length());
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
