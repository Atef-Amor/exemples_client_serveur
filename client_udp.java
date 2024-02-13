import java.net.*;

public class client_udp {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 8888;

            String message = "Bonjour, serveur UDP!";
            byte[] data = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(data, data.length, serverAddress, serverPort);

            socket.send(sendPacket);
            System.out.println("Message envoyé au serveur.");
            byte[] buffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(receivePacket);
            String responseMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Réponse du serveur : " + responseMessage);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
