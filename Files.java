import java.io.File;

public class Files {

    boolean fileExist(String fileString) {
        File file = new File(fileString);

        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }
}