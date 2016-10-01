import java.util.ArrayList;
import java.util.List;

public class PicturePage {
	List<String> picturePage = new ArrayList<String>();
	Objects objects = new Objects();
	
	//constructor
	PicturePage() { 
		picturePage.add(0, "not defined");
		picturePage.add(1, objects.getObject(0));
		picturePage.add(2, objects.getObject(2));
		picturePage.add(3, objects.getObject(3));
		picturePage.add(4, objects.getObject(4));
	}
	
	public List<String> getList() {
		return picturePage;
	}
}