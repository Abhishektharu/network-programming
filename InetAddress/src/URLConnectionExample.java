
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class URLConnectionExample {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //get response from the server
            connection.setRequestMethod("GET");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder string = new StringBuilder();

                int charCode;
                StringBuilder stringBuilder = new StringBuilder();

                while ((charCode = reader.read()) != -1) {
                    // System.out.print((char) charCode);
                    stringBuilder.append((char) charCode);
                }

                System.out.println(stringBuilder.toString());
            } catch (Exception e) {
                System.out.println(e);
                // TODO: handle exception
            }
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }
}
