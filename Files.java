import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Files {
	UserInput input = new UserInput();
	Header header = new Header();
	
	void save() {
		
	}
	
	public class Save {

		public void createHeaderFile() throws Exception {
			//init. File and PrintWriter
			File headerFile = new File ("header.txt");
			headerFile.createNewFile(); // if file already exists will do nothing 

			Scanner headerSc = new Scanner(headerFile);	
			PrintWriter writeHeader = new PrintWriter("header.txt");
			
			//init. empty header.txt
			for(int i = 0; i<header.length; i++) {
				writeHeader.println("<" + i + ">");
			}
		}
	}

	
	void createHeader(File file) {
		Scanner scFile = new Scanner(file);
		for(int i = 0; scFile.hasNextLine(); i++) {
			header.set(i, scFile.nextLine());
		}
	}

	
	void exists(String file) {
		//static void headerExists(int object) throws Exception {

			if ((new File(file)).exists()) {
				File thisFile = new File(file);
				createHeader(thisFile);

				System.out.println("A header already exists. Options:\nOpen --------- [o]\nCreate new --- [n]");
				if(input.is("o")) {
					extendHeader(object);
				}
				else if(input.is("n")) {
					header.setEmpty(12);
					System.out.println("A new header was created");
					createHeaderObject(object);
				}
			}
			else {
				System.out.println("No header exists. A new header was created.");
				//init. empty header
				for(int i = 0; i<header.length; i++) {
					header[i] = "<" + i + ">";
				}
				createHeaderObject(object);
			}
		}
	}
}