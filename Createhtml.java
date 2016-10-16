/**
 * Created by Franz on 15.10.2016.
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Createhtml {
    private String title;
    private String picture;
    private int counter = 1;
    private int counter2 = 1;

    Createhtml(String title) {
        this.title = title;
    }

    public void create() throws Exception {
        File html = new File("./html/" + title + ".html");
        File header = new File("./html_config/" + title + "_header.txt");
        File tempHeader = new File("tempHeader.txt");

        html.createNewFile();
        header.createNewFile();
        tempHeader.createNewFile();

        Files2 f = new Files2();
        PrintWriter p = new PrintWriter(html);
        UserInput input = new UserInput();
        Scanner headerScan = new Scanner(header);
        Scanner tempHeaderScan = new Scanner(tempHeader);
        while (tempHeaderScan.hasNextLine()) {
            String line = tempHeaderScan.nextLine();
            switch (line) {
                case ("<!--TITLE-->"):
                    p.println("<title>" + title + "</title>");
                    break;
                case ("<!--HEADER CONTENTS-->"):
                    while (headerScan.hasNextLine()) {
                        switch (headerScan.nextLine()) {
                            case ("<Picture>"):
                                File dir2 = new File("./pictures");
                                dir2.mkdirs();
                                List<String> pictureCheck = f.checkDir("./pictures", ".png");
                                List<String> existing = new ArrayList<>();
                                try {
                                    pictureCheck.get(0);
                                    int fileNr = 1;
                                    System.out.println("Which picture do you want to use for picture " + counter + "?");
                                    for (String s : pictureCheck) {
                                        existing.add(s.substring(11));
                                        System.out.println(fileNr + ": " + s.substring(11));
                                        fileNr++;
                                    }
                                    int userInput = input.getInt() - 1;
                                    picture = existing.get(userInput);
                                } catch (IndexOutOfBoundsException k) {
                                    System.out.println("Found no pictures to use\n" +
                                            "Created standard empty picture \"empty.png\"");
                                    picture = "empty.png";
                                    File empty = new File("./pictures/" + picture);
                                    empty.createNewFile();
                                }
                                p.println("<a href=\"https://www.facebook.com/sebastianbrg\" class=\"navbar-header\"><img class=\"img-l\" src=\"../pictures/" + picture + "\" alt=\"Sebastian er g\"></a>");
                                counter++;
                                break;
                            case ("<Hyperlink>"):
                                System.out.println("What text do you want for hyperlink " + counter2 + "?");
                                p.println("<a href=\"https://www.facebook.com/sebastianbrg\" class=\"m-l-s navbar-links\">"+ input.getString() + "</a>");
                                break;
                            default:
                                break;
                        }
                    }
                default:
                    p.println(line);
                    break;
            }
        }
        p.close();
    }
}