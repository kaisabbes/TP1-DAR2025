package clientPackage;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String serverIP = "192.168.1.171";
            int port = 1234;
            InetAddress ipAddress = InetAddress.getByName(serverIP);
            InetSocketAddress serverAddress = new InetSocketAddress(ipAddress, port);

            System.out.println("Tentative de connexion au serveur " + serverIP + ":" + port);
            Socket socket = new Socket();
            socket.connect(serverAddress);
            System.out.println("Connecté au serveur !");

            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            int choix;
            double a, b, resultat;
            do {
                System.out.println("1. Addition");
                System.out.println("2. Soustraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("0. Quitter");
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();
                os.writeInt(choix);
                if (choix == 0) break;
                System.out.print("Entrez le premier nombre : ");
                a = scanner.nextDouble();
                System.out.print("Entrez le deuxième nombre : ");
                b = scanner.nextDouble();
                os.writeDouble(a);
                os.writeDouble(b);
                resultat = is.readDouble();
                System.out.println("Résultat reçu du serveur : " + resultat);
            } while (true);
            is.close();
            os.close();
            socket.close();
            System.out.println("Connexion fermée.");
        } catch (IOException e) {
            System.out.println("Erreur client : " + e.getMessage());
        }
    }
}