import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Header {

	private static String [] headerArray = new String[12];
	Files file = new Files();
	ChosenPageType cpt = new ChosenPageType();

	void readHeader() throws Exception {
		UserInput input = new UserInput();
		if (file.fileExist("header.txt")) {
			System.out.println("A header already exists. Options:\nOpen --------- [o]\nCreate new --- [n]");
			String thisInput = input.getString();

			if(thisInput.equalsIgnoreCase("o")) {
				File headerFile = new File("header.txt");
				Scanner sc = new Scanner(headerFile);
				for(int i = 0; sc.hasNextLine(); i++) {
					headerArray[i] = sc.nextLine();
				}
				extendHeader();
			}
			else if(thisInput.equalsIgnoreCase("n")) {
				//init. empty header
				for(int i = 0; i<headerArray.length; i++) {
					headerArray[i] = "<" + i + ">";
				}
				System.out.println("A new header was created");
				createHeaderObject();
			}
		}
		else {
			System.out.println("No header exists. A new header was created.");
			//init. empty header
			for(int i = 0; i<headerArray.length; i++) {
				headerArray[i] = "<" + i + ">";
			}
			createHeaderObject();
		}
	}
	
	void createHeaderObject() throws Exception {
		UserInput input = new UserInput();
		System.out.println("Current header:\n" + Arrays.toString(headerArray)); 
		System.out.println("Select position to start your " + cpt.getObjectContent());
		
		int position = input.getInt();
		
		if (!(position>headerArray.length)) {
			headerArray[position]="<START>";
			System.out.println("Does <START> mark the correct starting point? [y/n]:\n" + Arrays.toString(headerArray)); 
			Scanner sc = new Scanner(System.in);
			String userInput = sc.nextLine();
			if (userInput.equalsIgnoreCase("n")) {
				for(int i = 0; i<headerArray.length; i++) {
					headerArray[i] = "<" + i + ">";
				}
				createHeaderObject();
			}

			else if (userInput.equalsIgnoreCase("y")) {
				System.out.println("Please define the size of your " + cpt.getObjectContent());
				int size = input.getInt();
				while(!(size<5)) {
					System.out.println("The maximum object size is 4");
					size = input.getInt();
				}
				int counter = 0;
				while(position<headerArray.length && counter<size) {
					headerArray[position] = cpt.getObjectContent();
					position++;
					counter++;
				}
				System.out.println("This is your new header:\n" + Arrays.toString(headerArray));
				saveHeader();
				return;
			}
			else {
				System.out.println("Invalid input, please try again!");
			}
		}	
		else {
			System.out.println("The starting position must be between 0 and 11");
			createHeaderObject();
		}
	}

	void extendHeader() throws Exception {
		File headerFile = new File("header.txt");
		Scanner scFile = new Scanner(headerFile);
		UserInput input = new UserInput();
		
		System.out.println("Current header:\n" + Arrays.toString(headerArray)); 
		System.out.println("Select position to start your " + cpt.getObjectContent());
		int position = input.getInt();
		if (!(position>headerArray.length)) {
			headerArray[position]="<START>";
			System.out.println("Does <START> mark the correct starting point? [y/n]:\n" + Arrays.toString(headerArray)); 
			Scanner sc = new Scanner(System.in);
			String userInput = sc.nextLine();
			if (userInput.equalsIgnoreCase("n")) {
				for(int i = 0; scFile.hasNextLine(); i++) {
					headerArray[i] = scFile.nextLine();
				}
				extendHeader();
			}

			else if (userInput.equalsIgnoreCase("y")) {
				System.out.println("Please define the size of your " + cpt.getObjectContent());
				int size = input.getInt();
				while(!(size<5)) {
					System.out.println("The maximum object size is 4");
					size = input.getInt();
				}
				int counter = 0;
				while(position<headerArray.length && counter<size) {
					headerArray[position] = cpt.getObjectContent();
					position++;
					counter++;
				}
				System.out.println("This is your new header:\n" + Arrays.toString(headerArray));
				saveHeader();
				return;
			}
			else {
				System.out.println("Invalid input, please try again!");
			}
		}	
		else {
			System.out.println("The starting position must be between 0 and 11");
			createHeaderObject();
		}
	}
	
	void saveHeader() throws Exception {
		File headerFile = new File("header.txt");

		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to save your header [y/n]");
		String input = sc.nextLine();
		if (input.equalsIgnoreCase("y")) {
			headerFile.createNewFile();
			PrintWriter print = new PrintWriter("header.txt");
			for(int i = 0; i<headerArray.length; i++) {
				print.println(headerArray[i]);
			}
			print.close();
			System.out.println("Your header was successfully saved to the file \"header.txt\" ");
		}
		else if (input.equalsIgnoreCase("n")) {
			System.out.println("Your new header was not saved.");
		}
	}
}