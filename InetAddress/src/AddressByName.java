
import java.net.InetAddress;
import java.net.UnknownHostException;



/**
 * AddressByName
 */
public class AddressByName {

    public static void main(String[] args) {
        try {
            // InetAddress address = InetAddress.getByName("www.oreilly.com");
            InetAddress address = InetAddress.getByName("142.250.194.164");
            // System.out.println(address);
            System.out.println(address.getHostName()); //returns host name;

            //to find all the host names;
            // InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
            // for(InetAddress address : addresses){
            //     System.out.println(address.getHostAddress());
            // }

        } catch (UnknownHostException e) {
            // TODO: handle exception
            System.err.println(e);
        }
    }
}