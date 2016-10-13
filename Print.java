import java.util.List;

public class Print {

    void list(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                System.out.println(list.get(i));
            } else {
                System.out.println("    " + i + " " + list.get(i));
            }
        }
    }
}