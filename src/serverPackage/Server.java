package serverPackage;
import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) {
        try {
            InetAddress ipAddress = InetAddress.getLocalHost();
            int port = 1234;
            InetSocketAddress serverAddress = new InetSocketAddress(ipAddress, port);
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(serverAddress);
            System.out.println("Serveur en écoute sur " + ipAddress.getHostAddress() + ":" + port);
            System.out.println("En attente de connexion d’un client...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connecté depuis " + clientSocket.getInetAddress().getHostAddress());
            DataInputStream is = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());
            int choix;
            double a, b, resultat;
            do {
                choix = is.readInt();
                if (choix == 0) {
                    System.out.println("Le client a quitté la session.");
                    break;
                }
                a = is.readDouble();
                b = is.readDouble();
                resultat = 0;
                switch (choix) {
                    case 1: resultat = a + b; break;
                    case 2: resultat = a - b; break;
                    case 3: resultat = a * b; break;
                    case 4:
                        if (b != 0) {
                            resultat = a / b;
                        } else {
                            System.out.println("Erreur : division par zéro !");
                        }
                        break;
                    default:
                        System.out.println("Choix invalide !");
                        break;
                }
                os.writeDouble(resultat);
                System.out.println("Opération exécutée (choix " + choix + ") : Résultat = " + resultat);
            } while (true);
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