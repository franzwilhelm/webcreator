import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChosenPageType extends Main{
	public static Article article = new Article();
	public static PicturePage picPage = new PicturePage();
	public static List<String> chosenType = new ArrayList<String>();

	public void chooseType (int typeIndex) {
		if (typeIndex == 1) {
			chosenType = article.getList();
		}
		else if (typeIndex == 2) {
			chosenType = picPage.getList();		
		}
	}

	void printObjects() {
		System.out.println("Available objects are: ");
		for(int i=1; i<chosenType.size(); i++) {
			System.out.println("    " + i + " " + chosenType.get(i));
		}
	}
	
	String getObject(int index) {
		return chosenType.get(index);
	}
	
	int getSize() {
		return chosenType.size();
	}
}



