import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Header {
	/*public Scanner sc = new Scanner("header.txt");
	public int type = Integer.parseInt(sc.nextLine());
	 */
	void readHeader() { 
		try {	
			File pageType = new File("header.txt");
		}
		catch(Exception headerNotFound) {

		}
	}
/*
	 pageType.createNewFile();
			PrintWriter write = new PrintWriter("pagetype.txt");
			write.println(type); */
	void set(int position, String content) {
		String[] header = new String[12];
		header[position] = content;
	}

	void setEmpty(int size) {
		String[] header = new String[size];
		for(int i = 0; i<header.length; i++) {
			header[i] = ("<" + i + ">");
		}
		System.out.println("New header created.\n" + "This is your current hreader:\n" + Arrays.toString(header));
	}
}