import java.net.*;


public class UDPClient {
    public static void main(String[] args) {
        try {
                    //udp connection 
        DatagramSocket socket = new DatagramSocket();

        InetAddress address = InetAddress.getByName("localhost");

        //buffer 
        byte[] buffer = "hello".getBytes();

        //packets
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 1006);

        socket.send(packet);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
