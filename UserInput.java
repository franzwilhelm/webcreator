import java.util.Scanner;

public class UserInput extends ChosenPageType{
    //init.
    ChosenPageType cpt = new ChosenPageType();

    int getInt() {
        Scanner sc = new Scanner(System.in);
        try {
            int integer = Integer.parseInt(sc.nextLine());
            return integer;
        } catch (NumberFormatException Exception) {
            System.out.println("You didnt state an integer, try again!");
            return getInt();
        }
    }

    int getInt2(String a) {
        Scanner sc = new Scanner(a);
        try {
            int integer = sc.nextInt();
            return integer;
        } catch (NumberFormatException Exception) {
            System.out.println("You didnt state an integer, try again!");
            return getInt();
        }
    }

    String getString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    int getType() {
        int type = getInt();

        if (type > 0 && type < chosenType.size()) {
            System.out.println("You have chosen: " + chosenType.get(type));
            return type;
        }
        System.out.println("The specified design is not on the list");
        return 0;
    }
}