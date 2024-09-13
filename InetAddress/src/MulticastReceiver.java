import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {
    public static void main(String[] args) {
        MulticastSocket socket = null;
        try {
            // Create a MulticastSocket at port 4446
            socket = new MulticastSocket(4446);
            
            // Join the multicast group at IP address 230.0.0.1
            InetAddress group = InetAddress.getByName("230.0.0.1");
            socket.joinGroup(group);

            // Buffer to receive data
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);

            // Receive the multicast packet
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());

            // Display the received message
            System.out.println("Received: " + received);
            
            // Leave the multicast group
            socket.leaveGroup(group);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
