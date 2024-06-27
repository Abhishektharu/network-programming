import java.io.*;
import java.net.*;

public class GetMethodExample {
    public static void main(String[] args) throws  IOException {
        URL url = new URL("http://httpbin.org/get?id=1234");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("Accept", "application/json");

        BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;
        while ((line = buffer.readLine()) != null) {
            System.out.println(line);
        }

        buffer.close();
    }
}
