import java.util.ArrayList;
import java.util.List;

public class Objects {
    public static List<String> objects = new ArrayList<String>();

    //constructor
    Objects() {
        objects.add(0, "<Picture>");
        objects.add(1, "<Text>");
        objects.add(2, "<Hyperlink>");
        objects.add(3, "<Button>");
    }

    String getObject(int index) {
        return objects.get(index);
    }
}