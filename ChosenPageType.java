import java.util.ArrayList;
import java.util.List;


public class ChosenPageType {
<<<<<<< HEAD
    static List<String> chosenType = new ArrayList<>();
    private static int object;
    private static int objectPlacement;

    ChosenPageType() {

    }

    void addObject(String object) {
        chosenType.add(object);
=======
    private static List<String> chosenType = new ArrayList<String>();
    private static int object;
    private static int objectPlacement;
    PageType pt = new PageType();

    void setType() {
        Article article = new Article();
        PicturePage picPage = new PicturePage();
        UserInput input = new UserInput();
        int type = input.getInt();

        if (type > 0 && type < pt.getTypes().size()) {
            System.out.println("You have chosen: " + pt.getTypes().get(type));
            if (type == 1) {
                chosenType = article.getList();
            } else if (type == 2) {
                chosenType = picPage.getList();
            }
        } else {
            System.out.println("The specified design is not on the list, try again");
            setType();
        }
>>>>>>> refs/remotes/origin/wip-leggetiljava
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
<<<<<<< HEAD
        System.out.println("Your " + getObjectContent() + " is to be put in the header");
        objectPlacement = 1;
=======
        UserInput input = new UserInput();
        System.out.println("Where do you want to put your " + getObjectContent());
        System.out.println("    1 HEADER");
        System.out.println("    2 MAIN");

        int placement = input.getInt();
        if (placement == 1) {
            objectPlacement = placement;
        } else if (placement == 2) {
            System.out.println("MAIN is not initialized yet, choose another placement");
            setObjectPlacement();
        } else {
            System.out.println("The specified placement is not on the list");
            setObjectPlacement();
        }
>>>>>>> refs/remotes/origin/wip-leggetiljava
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
<<<<<<< HEAD
=======

    int getObjectPlacement() {
        return objectPlacement;
    }

    int getObject() {
        return object;
    }
>>>>>>> refs/remotes/origin/wip-leggetiljava
}