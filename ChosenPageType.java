import java.util.ArrayList;
import java.util.List;


public class ChosenPageType {
    static List<String> chosenType = new ArrayList<>();
    private static int object;
    private static int objectPlacement;

    ChosenPageType() {

    }

    void addObject(String object) {
        chosenType.add(object);
    }

    void setObject() {
        UserInput input = new UserInput();
        int thisObject = input.getInt();
        if (thisObject > 0 && thisObject > (getSize() - 1)) {
            System.out.println("The specified object is not on the list. Try again");
            setObject();
        } else {
            object = thisObject;
        }
    }

    void setObjectPlacement() {
        System.out.println("Your " + getObjectContent() + " is to be put in the header");
        objectPlacement = 1;
    }

    List<String> getObjects() {
        return chosenType;
    }

    String getObjectContent() {
        return chosenType.get(object);
    }

    int getSize() {
        return chosenType.size();
    }
}