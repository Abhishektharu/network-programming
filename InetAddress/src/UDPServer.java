
import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try {
                    //create udp socket
        DatagramSocket socket = new DatagramSocket(1006); 
        System.out.println("Server started...");
        
        //receiving packet 
        // Socket.receive(packet);
        
        byte[] buffer = new byte[1024];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);



        socket.receive(packet);

        String message = new String(packet.getData(), 0, packet.getLength() );

        System.out.println(message);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
