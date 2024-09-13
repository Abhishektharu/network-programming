
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class DictOrg {

    public static void main(String[] args) {

        String query = "book";

        try {
            URL url = new URL("https://dict.org/bin/Dict"  + query);

            try (InputStream bufferIn = new BufferedInputStream(url.openStream())) {
                InputStreamReader reader = new InputStreamReader(bufferIn);

                int c;
                while((c = reader.read()) != -1){
                    System.out.println((char) c );

                }
                
            } catch (Exception e) {
                // TODO: handle exception
                
            }
        }catch(MalformedURLException ex){
            System.err.println(ex);
        }
    }

}
