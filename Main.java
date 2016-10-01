public class Main {
	public static void main(String[]args) {
		//initializing classes
		PageType pt = new PageType();
		UserInput input = new UserInput();
		ChosenPageType cpt = new ChosenPageType();
		Header hd = new Header();
		Print print = new Print();
		
		print.list(pt.getTypes());
		
		int type = pt.setType();
		/*
		cpt.chooseType(type);
		cpt.printObjects();
		int object = input.getObject();
		
		int placement = 0;
		while (placement == 0) {
			placement = input.getPlacement(object);
		}
		
		if (placement == 1) {
			hd.readHeader();

			System.out.println("No header exists. Do you want to create a new one? [y/n]");
			if (input.is("n")) {
				System.out.println("program is done");
			}
			else if (input.is("y")) {
				hd.setEmpty(12);
			}
			else {
				System.out.println("k");
			}
		}
		*/
	}
	
	
	static void extendHeader(int object) throws Exception {
		File headerFile = new File("header.txt");
		Scanner scFile = new Scanner(headerFile);
		System.out.println("Current header:\n" + Arrays.toString(header)); 
		System.out.println("Select position to start your " + chosenType.get(object));
		int position = userSc.nextInt();
		if (!(position>header.length)) {
			header[position]="<START>";
			System.out.println("Does <START> mark the correct starting point? [y/n]:\n" + Arrays.toString(header)); 
			Scanner sc = new Scanner(System.in);
			String userInput = sc.nextLine();
			if (userInput.equalsIgnoreCase("n")) {
				for(int i = 0; scFile.hasNextLine(); i++) {
					header[i] = scFile.nextLine();
				}
				extendHeader(object);
			}

			else if (userInput.equalsIgnoreCase("y")) {
				System.out.println("Please define the size of your " + chosenType.get(object));
				int size = userSc.nextInt();
				while(!(size<5)) {
					System.out.println("The maximum object size is 4");
					size = userSc.nextInt();
				}
				int counter = 0;
				while(position<header.length && counter<size) {
					header[position] = chosenType.get(object);
					position++;
					counter++;
				}
				System.out.println("This is your new header:\n" + Arrays.toString(header));
				saveHeader();
				return;
			}
			else {
				System.out.println("Invalid input, please try again!");
			}
		}	
		else {
			System.out.println("The starting position must be between 0 and 11");
			createHeaderObject(object);
		}
	}

	static void createHeaderObject(int object) throws Exception {
		System.out.println("Current header:\n" + Arrays.toString(header)); 
		System.out.println("Select position to start your " + chosenType.get(object));
		int position = userSc.nextInt();
		if (!(position>header.length)) {
			header[position]="<START>";
			System.out.println("Does <START> mark the correct starting point? [y/n]:\n" + Arrays.toString(header)); 
			Scanner sc = new Scanner(System.in);
			String userInput = sc.nextLine();
			if (userInput.equalsIgnoreCase("n")) {
				for(int i = 0; i<header.length; i++) {
					header[i] = "<" + i + ">";
				}
				createHeaderObject(object);
			}

			else if (userInput.equalsIgnoreCase("y")) {
				System.out.println("Please define the size of your " + chosenType.get(object));
				int size = userSc.nextInt();
				while(!(size<5)) {
					System.out.println("The maximum object size is 4");
					size = userSc.nextInt();
				}
				int counter = 0;
				while(position<header.length && counter<size) {
					header[position] = chosenType.get(object);
					position++;
					counter++;
				}
				System.out.println("This is your new header:\n" + Arrays.toString(header));
				saveHeader();
				return;
			}
			else {
				System.out.println("Invalid input, please try again!");
			}
		}	
		else {
			System.out.println("The starting position must be between 0 and 11");
			createHeaderObject(object);
		}
	}

	static void saveHeader() throws Exception {
		File headerFile = new File("header.txt");

		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to save your header [y/n]");
		String input = sc.nextLine();
		if (input.equalsIgnoreCase("y")) {
			headerFile.createNewFile();
			PrintWriter print = new PrintWriter("header.txt");
			for(int i = 0; i<header.length; i++) {
				print.println(header[i]);
			}
			print.close();
			System.out.println("Your header was successfully saved to the file \"header.txt\" ");
		}
		else if (input.equalsIgnoreCase("n")) {
			System.out.println("Your new header was not saved.");
		}
	}
}
