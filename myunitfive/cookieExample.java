
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class cookieExample {
    public static void main(String[] args) throws IOException, URISyntaxException{

        URL url = new URL("http://example.com");
        CookieManager cookieManager = new CookieManager();

        CookieHandler.setDefault(cookieManager);

        HttpCookie cookie1 = new HttpCookie("abhishek", "chaudhary");
        cookieManager.getCookieStore().add(url.toURI(), cookie1);

        // Retrieve cookies from the CookieStore
        List<HttpCookie> cookies = cookieManager.getCookieStore().get(url.toURI());

        for(HttpCookie cookie: cookies){
            System.out.println("Name: " + cookie.getName());
            System.out.println("Value: " + cookie.getValue());
        }
        
    }
}
