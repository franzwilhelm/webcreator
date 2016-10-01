import java.util.ArrayList;
import java.util.List;

public class Objects {
	List<String> objects = new ArrayList<String>();
	//constructor
	Objects() {
		objects.add(0, "<Picture>");
		objects.add(1, "<Text>");
		objects.add(2, "<Hyperlink>");
		objects.add(3, "<Button>");
		objects.add(4, "<Animation>");
		objects.add(5, "<javascript>");
		objects.add(6, "<lol>");
	}
	String getObject(int index) {
		return objects.get(index);
	}	
}