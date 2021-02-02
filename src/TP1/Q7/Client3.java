package TP1.Q7;

import TP1.Q5.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client3 {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 2500);
            while (true) {
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                Scanner sc = new Scanner(System.in);
                System.out.println("saisir votre chaine :");
                String str = sc.nextLine();
                dout.writeUTF(str);
                dout.flush();
                DataInputStream din = new DataInputStream(s.getInputStream());
                int taille = din.read();
                System.out.println("taile :" + taille);

                if (str.equals("QUITTER")) {
                    din.close();
                    dout.close();
                    s.close();
                }

            }
        } catch (IOException ex) {
            System.out.println("exit");
        }

    }

}
