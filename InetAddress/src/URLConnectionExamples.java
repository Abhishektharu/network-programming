import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class URLConnectionExamples {
    public static void main(String[] args) {
        try {
            // 5.1: Opening URLConnections
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 5.5: Configuring the Connection
            connection.setRequestMethod("GET");
            connection.setDoInput(true); // doInput: true to read server response
            connection.setDoOutput(false); // doOutput: false for a GET request
            connection.setUseCaches(false); // disable caching
            connection.setConnectTimeout(5000); // 5 seconds connection timeout
            connection.setReadTimeout(5000); // 5 seconds read timeout

            // 5.6: Configuring the Client Request HTTP Header
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            // 5.2: Reading Data from Server
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Print the response from the server
                System.out.println("Response from server:");
                System.out.println(response.toString());
            }

            // 5.3: Reading Header: Retrieving specific Header Fields
            Map<String, List<String>> headerFields = connection.getHeaderFields();
            System.out.println("\nHeaders:");
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Retrieve specific header fields
            String contentType = connection.getHeaderField("Content-Type");
            System.out.println("\nContent-Type: " + contentType);

            // 5.8: Guessing MIME Media Types
            String mimeType = connection.getContentType();
            System.out.println("\nMIME Type: " + mimeType);

            // 5.4: Cache: Web Cache for Java (not implemented, but you can use external libraries for caching)

            // 5.9: Handling Server Responses, Proxies, and Streaming Mode
            // We handled server response above with the responseCode and input stream
            // You can set up proxies and streaming mode if needed:
            // connection.setChunkedStreamingMode(1024); // For chunked streaming mode
            // connection.usingProxy(); // To check if using a proxy

            // Disconnecting from the server
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
