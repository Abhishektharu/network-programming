
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ObjectMethods {

    public static void main(String[] args) {
        try {
            InetAddress ibiblio = InetAddress.getByName("www.ibiblio.org");
            InetAddress helios = InetAddress.getByName("helios.ibiblio.org");

            if(ibiblio.equals(helios)){
                System.out.println(ibiblio.getHostName() + helios.getHostName() + " are same. ");
            }
            else{
                System.out.println("www.ibiblio.org is not the same as helios.ibiblio.org");
            }
        } catch (UnknownHostException e) {
            // TODO: handle exception
            System.out.println("Host Lookup failed. ");
        }
    }
}
