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

public class Main {
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
            System.out.println("Do you wish to add additional objects? [y/n]");
            String check = input.getString();
            if (check.equalsIgnoreCase("y")) {
                hd.readHeader();
            } else if (check.equalsIgnoreCase("n")) {
                System.out.println("[program terminated]");
                loop = false;
                return;
            }
        }
    }
}
