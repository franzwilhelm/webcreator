import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class PageType {
	List<String> types = new ArrayList<String>();
	public static Article article = new Article();
	public static PicturePage picPage = new PicturePage();
	public static List<String> chosenType = new ArrayList<String>();

	public void chooseType (int typeIndex) {

	}
	
	//constructor
	PageType() {
		types.add("Enter the desired number to get more options\nThe available web page interfaces are:");
		types.add("Article");
		types.add("Picture page");
	}
	
	List<String> getTypes() {
		return types;
	}
	
	int setType() {
		UserInput input = new UserInput();
		int type = input.getInt();

		if (type>0 && type<types.size()) {
			int thisType = types.get(type);
			System.out.println("You have chosen: " + types.get(type));
			
			java.lang.reflect.Method method;
			Object obj = types.get(type);
			try {
			  method = obj.getClass().getMethod("getList()");
			} catch (SecurityException e) { }
			  catch (NoSuchMethodException e) { }
			
			try {
				  method.invoke(obj, "getList()");
				} catch (IllegalArgumentException e) {}
				  catch (IllegalAccessException e) {  }
				  catch (InvocationTargetException e) { }
			
			if (thisType == 1) {
				chosenType = article.getList();
			}
			else if (thisType == 2) {
				chosenType = picPage.getList();		
			}
		}
		System.out.println("The specified design is not on the list, try again");
		return setType();
	}
}
