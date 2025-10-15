package clientPackage;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Je suis un client pas encore connecté…");
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Je suis un client connecté !");
            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            int x;
            do {
                System.out.print("Entrez un entier (0 pour quitter) : ");
                x = scanner.nextInt();
                os.writeInt(x);
                if (x != 0) {
                    int resultat = is.readInt();
                    System.out.println("Résultat reçu du serveur : " + resultat);
                }
            } while (x != 0);
            is.close();
            os.close();
            socket.close();
            System.out.println("Connexion fermée.");
        } catch (IOException e) {
            System.out.println("Erreur client : " + e.getMessage());
        }
    }
}
