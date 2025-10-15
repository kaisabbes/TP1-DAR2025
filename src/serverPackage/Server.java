package serverPackage;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Serveur en attente de connexion...");
            Socket clientSocket = serverSocket.accept();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Connexion fermée. Serveur arrêté.");
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}