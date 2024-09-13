package urlsclass.ProtocolTester;

import java.net.MalformedURLException;
import java.net.URL;

public class RelativeURLs {

    public static void main(String[] args) {
        try {
            URL u1 = new URL("http://www.ibiblio.org/javafaq/index.html");
            @SuppressWarnings("deprecation")
            URL u2 = new URL(u1, "mailinglists.html");


//             The filename is removed from the path of u1 and the new filename mailinglists.html is
//  appended to make u2. This constructor is particularly useful when you want to loop
//  through a list of files that are all in the same directory. You can create a URL for the first
//  file and then use this initial URL to create URL objects for the other files by substituting
//  their filenames.

            System.out.println("the file is : " + u2.getFile());
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }
    }
}
