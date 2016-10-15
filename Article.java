import java.util.ArrayList;
import java.util.List;


public class Article {
    private List<String> article = new ArrayList<String>();
    private Objects objects = new Objects();

    //constructor
    Article() {
        article.add(0, "Available objects are: ");
        article.add(1, objects.getObject(0));
        article.add(2, objects.getObject(1));
    }

    public List<String> getList() {
        return article;
    }
}
