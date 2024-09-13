
import java.net.InetAddress;
import java.net.UnknownHostException;



public class MyAddresss {
    public static void main(String[] args) {
        //get machine address;
        try {
            InetAddress me = InetAddress.getLocalHost();
        System.out.println(me.getHostAddress());
        } catch (UnknownHostException e) {
            // TODO: handle exception
        }
    }
}
