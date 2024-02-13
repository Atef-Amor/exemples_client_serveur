import java.net.*;
import java.io.*;

public class client_tcp {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12555);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String message = "Hello Server!";
            writer.write(message);
            writer.newLine();
            writer.flush();

            String responseMessage = reader.readLine();
            System.out.println("Message from server: " + responseMessage);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
