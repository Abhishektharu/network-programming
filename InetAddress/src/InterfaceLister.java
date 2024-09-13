
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class InterfaceLister {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println(ni);
        }
        // NetworkInterface eth0 = NetworkInterrface.getByName("eth0");
        // @SuppressWarnings("rawtypes")
        // Enumeration addresses = eth0.getInetAddresses();
        // while (addresses.hasMoreElements()) {
        //     System.out.println(addresses.nextElement());
        // }
    }
}
