
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class url {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.github.com/users");
            URLConnection con = url.openConnection();


            // retrrive data from the server/

            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String input;
            while((input = reader.readLine()) != null){
                // System.out.println(input);
            }
            
            System.out.println("protocol: " + url.getProtocol());
            System.out.println("path : " + url.getPath());
            System.out.println("host: " + url.getHost());
            System.out.println("port " + url.getPort());
            System.out.println("authority: " + url.getAuthority());
            System.out.println("content len: " + con.getHeaderField("content-length"));

            System.out.println();
            
            reader.close();

        } catch (Exception e) {
                // TODO: handle exception
        }
    }
}
