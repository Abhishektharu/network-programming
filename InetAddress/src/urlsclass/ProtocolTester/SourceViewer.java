package urlsclass.ProtocolTester;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class SourceViewer {

    public static void main(String[] args) {

        try {
            URL u = new URL("www.oreilly.com");
            try (InputStream in = u.openStream();) {
                //buffer input to increase performance
                InputStream buffer = new BufferedInputStream();
                //chain the buffer to reader
                InputStreamReader r = new InputStreamReader(buffer);
                int c;
                while ((c = r.read()) != -1) {
                    System.out.println((char) c);
                }
            } catch (MalformedURLException e) {
                // TODO: handle exception
                System.err.println(e);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
