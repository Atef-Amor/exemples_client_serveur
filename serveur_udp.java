import java.net.*;

public class serveur_udp {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket(8888);

            byte[] buffer = new byte[1024];

            System.out.println("Serveur UDP démarré sur le port 8888...");

            while (true) {
               
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

                socket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Message du client : " + message);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String responseMessage = "Message reçu : " + message;
                byte[] responseData = responseMessage.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}