package urlsclass.ProtocolTester;

import java.net.URLDecoder;

/**
 * EncoderClass
 * @author abhishek chaudhary
 * @
 */
public class EncoderClass {

    public static void main(String[] args) {
        try{
            // System.out.println(URLEncoder.encode("This string has spaces","UTF-8"));
            // System.out.println(URLEncoder.encode("This*string*has*asterisks","UTF-8"));
            // System.out.println(URLEncoder.encode("This%string%has%percent%signs","UTF-8"));
            // System.out.println(URLEncoder.encode("This+string+has+pluses","UTF-8"));
            // System.out.println(URLEncoder.encode("This/string/has/slashes","UTF-8"));


            System.out.println(URLDecoder.decode("file:///C:/Users/abhis/Downloads/[JAVA][Java%20Network%20Programming,%204th%20Edition].pdf", "UTF-8"));
        }catch(Exception ex){
            
        }
    }
}