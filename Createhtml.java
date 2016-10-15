/**
 * Created by Franz on 15.10.2016.
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Createhtml {
    void convert() throws Exception {
        File converted = new File("convertedHeader.txt");
        File header = new File("header.txt");
        PrintWriter p = new PrintWriter(converted);
        Scanner sc = new Scanner(header);

        while (sc.hasNextLine()) {
            switch (sc.nextLine()) {
                case ("<Picture>"):
                    p.println("<a href=\"https://www.facebook.com/sebastianbrg\" class=\"navbar-header\"><img class=\"img-l\" src=\"./picture.png\" alt=\"Sebastian er g\"></a>");
                    break;
                case ("<Text>"):
                    p.println("<a href=\"https://www.facebook.com/sebastianbrg\" class=\"m-l-s navbar-links\">The boss</a>");
                    break;
                default:
                    break;
            }
        }
        p.close();
    }

    void create() throws Exception {
        String[] files = {"headerStart.txt", "convertedHeader.txt", "headerEnd.txt"};
        File html = new File("header.html");
        html.createNewFile();
        PrintWriter p = new PrintWriter(html);

        for (String a : files) {
            File file = new File(a);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                p.println(sc.nextLine());
            }
        }
        p.close();
    }
}