package serverPackage;
import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Je suis un serveur en attente de la connexion d'un client");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Un client est connecté !");
            DataInputStream is = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());
            int x;
            do {
                x = is.readInt();
                System.out.println("Nombre reçu du client : " + x);
                if (x != 0) {
                    int resultat = x * 5;
                    System.out.println("Résultat calculé "+x+"*5) = " + resultat);
                    os.writeInt(resultat);
                }
            } while (x != 0);
            is.close();
            os.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Serveur fermé.");
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}