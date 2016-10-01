import java.util.Scanner;


public class UserInput {
	//init.

	int getInt() throws NumberFormatException {
		Scanner sc = new Scanner(System.in);
		try {
			int integer = Integer.parseInt(sc.nextLine());
			return integer;
		}
		catch (NumberFormatException Exception) { 
			System.out.println("You didnt state an integer, try again!"); 
			return getInt();
		}
	}

	String getString() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	

	int getObject() {
		ChosenPageType cpt = new ChosenPageType();
		int object = getInt();
		while(!(object>0 && object<cpt.getSize())) {
			System.out.println("The specified object is not on the list. Try again");
			getObject();
		}
		return object;
	}

	int getPlacement(int object) {
		ChosenPageType cpt = new ChosenPageType();
		System.out.println("Where do you want to put your " + cpt.getObject(object));
		System.out.println("    1 HEADER");
		System.out.println("    2 MAIN");

		int placement = getInt();
		if (placement == 1) {
			return placement;
		}
		else if (placement == 2) {
			System.out.println("MAIN is not initialized yet, choose another placement");
			return 0;
		}
		else {
			System.out.println("The specified placement is not on the list");
			return 0;
		}
	}

	boolean is(String define_string) {
		if(getString().equalsIgnoreCase(define_string)){
			return true;
		}
		else {
			return false;
		}
	}
}