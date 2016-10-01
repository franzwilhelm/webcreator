import java.util.ArrayList;
import java.util.List;


public class Article {
	public static List<String> article = new ArrayList<String>();
	public static Objects objects = new Objects();
	
	//constructor
	Article() { 
		article.add(0, "not defined");
		article.add(1, objects.getObject(0));
		article.add(2, objects.getObject(1));
		article.add(3, objects.getObject(2));
		article.add(4, objects.getObject(2));
		article.add(5, objects.getObject(4));
		article.add(6, objects.getObject(5));
		article.add(7, objects.getObject(6));
	}
	
	public List<String> getList() {
		return article;
	}
}
