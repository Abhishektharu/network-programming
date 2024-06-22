import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequestWithHandling {
    public static void main(String[] args) {
        try {
            // Create a URL object
            URL url = new URL("http://example.com/api/resource");
            
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set the request method to GET
            connection.setRequestMethod("GET");
            
            // Set request headers if necessary
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            
            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            // Check if the response code is 200 (OK)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                // Print the response
                System.out.println(response.toString());
            } else {
                System.out.println("Error: " + connection.getResponseMessage());
                // Handle different error codes appropriately here
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
