
// import java.net.InetAddress;
// import java.net.NetworkInterface;
// import java.net.SocketException;
// import java.net.UnknownHostException;


// public class NetworkInterfaceGetByName {
//     public static void main(String[] args) throws UnknownHostException {
//         try {
//             // NetworkInterface ni = NetworkInterface.getByName("eth0");
//             // if(ni == null){
//             //     System.out.println("No loopback address");
//             // }

//             InetAddress local = InetAddress.getByName("127.0.0.1");
//             NetworkInterface ni = NetworkInterface.getByInetAddress(local);

//             // if(ni == null){
//             //     System.out.println("No loopback address");
//             // }

//             System.out.println(ni.getInterfaceAddresses());
//             // System.out.println(ni.getNetworkInterfaces());
//         } catch (SocketException e) {
//             // TODO: handle exception
//         }

//     }
// }
import java.net.NetworkInterface;
import java.net.InetAddress;
import java.util.Enumeration;

public class NetworkInterfaceExample {
    public static void main(String[] args) {
        try {
            // Get all network interfaces
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                System.out.println("Interface Name: " + networkInterface.getName());
                
                // Get all addresses associated with the interface
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.println("InetAddress: " + inetAddress.getHostAddress());
                }
                System.out.println("-----------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
