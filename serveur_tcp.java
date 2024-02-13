import java.net.*;
import java.io.*;

public class serveur_tcp {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12555);
            System.out.println("Server is running and waiting for client connection...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            String clientMessage = reader.readLine();
            System.out.println("Message from client: " + clientMessage);

            // You can add your processing logic here

            String responseMessage = "Hello Client!";
            writer.write(responseMessage);
            writer.newLine();
            writer.flush();

            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
