package clientPackage;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Client en cours de connexion...");
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Connecté au serveur !");
            socket.close();
            System.out.println("Connexion fermée. Client terminé.");
        } catch (IOException e) {
            System.out.println("Erreur client : " + e.getMessage());
        }
    }
}
