import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSender {
    public static void main(String[] args) {
        MulticastSocket socket = null;
        try {
            // Create a MulticastSocket
            socket = new MulticastSocket();

            // Prepare the message to be sent
            String message = "Hello Multicast Group!";
            byte[] buf = message.getBytes();

            // Send the message to the multicast group at IP 230.0.0.1 and port 4446
            InetAddress group = InetAddress.getByName("230.0.0.1");
            DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
            socket.send(packet);

            System.out.println("Message sent to multicast group.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
