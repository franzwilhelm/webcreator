import java.util.ArrayList;
import java.util.List;


public class PageType {
    List<String> types = new ArrayList<String>();

    //constructor
    PageType() {
        types.add("Enter the desired number to get more options\nThe available web page interfaces are:");
        types.add("Article");
        types.add("Picture page");
    }

    List<String> getTypes() {
        return types;
    }
}

/*
look this up later
----------------------------
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
*/