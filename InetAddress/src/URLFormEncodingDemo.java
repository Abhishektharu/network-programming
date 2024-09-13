import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URLFormEncodingDemo {
    public static void main(String[] args) throws Exception {
        // Original data to be encoded
        String data = "name=John Doe&age=25";
        
        // Encoding data
        String encodedData = URLEncoder.encode(data, StandardCharsets.UTF_8);
        System.out.println("Encoded Data: " + encodedData);
        
        // Decoding data
        String decodedData = URLDecoder.decode(encodedData, StandardCharsets.UTF_8);
        System.out.println("Decoded Data: " + decodedData);
    }
}
