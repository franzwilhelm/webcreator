//make a program designed to create html web pages.

//NOTICE: this is only a small part of the program, and it is continuously extended.
///////////////////////////////////////////////////////////////////////////////////////
// CURRENT PATCH: v.0.0.2

/* patch v. 0.0.1 features:
 *  Create a header of the type article
 *	Save header
 *	Open existing header
 *	Edit existing header
 *	Create new header
 *	1 save slot for headers (header.txt)
 */

/* patch v. 0.0.2 features:
 *  Class division for easier workflow in future patches
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
<<<<<<< HEAD
    private static String title;

    public static void main(String[] args) throws Exception {
        //initializing classes
        UserInput input = new UserInput();
        Print print = new Print();
        ChosenPageType cpt = new ChosenPageType();
        Files2 f = new Files2();
        File dir = new File("./html/");
        File dir2 = new File("./html_config/");
        File dir3 = new File("./pictures/");
        dir.mkdirs();
        dir2.mkdirs();
        dir3.mkdirs();

        title = f.getTitle("./html", ".html");
        Createhtml html = new Createhtml(title);

        cpt.addObject("Available objects for " + title + " are:");
        cpt.addObject("<Picture>");
        cpt.addObject("<Hyperlink>");

        print.list(cpt.getObjects());
        cpt.setObject();
        cpt.setObjectPlacement();
        Header hd = new Header(title);
        hd.readHeader();

        while (true) {
=======
    public static void main(String[] args) throws Exception {
        //initializing classes
        PageType pt = new PageType();
        UserInput input = new UserInput();
        Print print = new Print();
        ChosenPageType cpt = new ChosenPageType();
        Header hd = new Header();

        print.list(pt.getTypes());
        cpt.setType();
        print.list(cpt.getObjects());
        cpt.setObject();
        cpt.setObjectPlacement();
        hd.readHeader();

        boolean loop = true;

        while (loop == true) {
>>>>>>> refs/remotes/origin/wip-leggetiljava
            System.out.println("Do you wish to add additional objects? [y/n]");
            String check = input.getString();
            if (check.equalsIgnoreCase("y")) {
                hd.readHeader();
            } else if (check.equalsIgnoreCase("n")) {
<<<<<<< HEAD
                html.create();
                System.out.println("[program terminated]");
                System.exit(0);
            }
        }
    }
}
=======
                System.out.println("[program terminated]");
                loop = false;
                return;
            }
        }
    }
}
>>>>>>> refs/remotes/origin/wip-leggetiljava
