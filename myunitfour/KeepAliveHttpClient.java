package myunitfour;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class KeepAliveHttpClient {
    public static void main(String[] args) {
        try {
            // Create a HttpClient instance
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .connectTimeout(Duration.ofSeconds(5))
                    .build();

            // Create a HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://example.com/api/resource"))
                    .timeout(Duration.ofSeconds(5))
                    .GET()
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the response
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

            // Get response headers
            response.headers().map().forEach((k, v) -> System.out.println(k + ":" + v));

            // The HttpClient instance can be reused for further requests
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
