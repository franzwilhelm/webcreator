import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Files2 {

    boolean fileExist(String fileString) {
        File file = new File(fileString);

        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    List<String> checkDir(String dir, String check) throws IOException {
        // get all the files from a directory
        File directory = new File(dir);
        directory.createNewFile();
        File[] fList = directory.listFiles();
        List<String> filer = new ArrayList<>();
        try {
            for (File file : fList) {
                if (file.isFile()) {
                    if (file.getName().endsWith(check)) {
                        filer.add(file.toString());
                    }
                }
            }
            return filer;
        } catch (NullPointerException e) {
            return null;
        }
    }

    String getTitle(String dir, String fileType) throws IOException {
        UserInput input = new UserInput();
        List<String> html2 = checkDir(dir, fileType);
        List<String> existing = new ArrayList<>();
        try {
            html2.get(0);
            int fileNr = 1;
            System.out.println("Found html file(s) in subdirectory:");
            for (String s : html2) {
                existing.add(s.substring(7));
                System.out.println(fileNr + ": " + s.substring(7));
                fileNr++;
            }
            System.out.println("Open -- [o + filenr.]\n" +
                    "New --- [n]");
            String userInput = input.getString();
            if (userInput.contains("o")) {
                int ok = Integer.parseInt(userInput.replaceAll("[\\D]", ""));
                return existing.get(ok - 1).substring(0, existing.get(ok - 1).length() - 5);
            } else if (userInput.contains("n")) {
                System.out.println("What do you want to name your new web page?");
                return (input.getString());
            } else {
                System.out.println("Not valid. Try again!");
                return getTitle(dir, fileType);
            }
        } catch (Exception k) {
            System.out.println("Found no existing projects\n" +
                    "What is the name of your new web page?");
        }
        return (input.getString());
    }


}
