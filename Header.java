import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Header {
    private int headerSize = 6;
    private String[] tempArray = new String[headerSize];
    private String[] startArray = new String[headerSize];
    private String[] headerArray = new String[headerSize];
    private String title;
    Files2 file = new Files2();
    ChosenPageType cpt = new ChosenPageType();

    Header(String title) {
        this.title = title;
    }

    void readHeader() throws Exception {
        UserInput input = new UserInput();
        if (file.fileExist("./html_config/" + title + "_header.txt")) {
            System.out.println("A header already exists. Options:\nOpen --------- [o]\nCreate new --- [n]");
            String thisInput = input.getString();

            if (thisInput.equalsIgnoreCase("o")) {
                File headerFile = new File("./html_config/" + title + "_header.txt");
                Scanner sc = new Scanner(headerFile);
                for (int i = 0; sc.hasNextLine(); i++) {
                    String scanned = sc.nextLine();
                    headerArray[i] = scanned;
                    if (scanned.equals("<>")) {
                        startArray[i] = "<" + i + ">";
                    } else {
                        startArray[i] = scanned;
                    }
                    for (int j = 0; j < startArray.length; j++) tempArray[j] = startArray[j];
                }
                extendHeader();
            } else if (thisInput.equalsIgnoreCase("n")) {
                //init. empty header
                for (int i = 0; i < tempArray.length; i++) {
                    tempArray[i] = "<" + i + ">";
                    headerArray[i] = "<>";
                }
                System.out.println("A new header was created");
                createHeaderObject();
            }
        } else {
            //init. empty header
            for (int i = 0; i < tempArray.length; i++) {
                tempArray[i] = "<" + i + ">";
            }
            createHeaderObject();
        }
    }

<<<<<<< HEAD
=======
    private static String[] tempArray = new String[12];
    private static String[] startArray = new String[12];
    private static String[] headerArray = new String[12];
    Files file = new Files();
    ChosenPageType cpt = new ChosenPageType();

    void readHeader() throws Exception {
        UserInput input = new UserInput();
        if (file.fileExist("header.txt")) {
            System.out.println("A header already exists. Options:\nOpen --------- [o]\nCreate new --- [n]");
            String thisInput = input.getString();

            if (thisInput.equalsIgnoreCase("o")) {
                File headerFile = new File("header.txt");
                Scanner sc = new Scanner(headerFile);
                for (int i = 0; sc.hasNextLine(); i++) {
                    String scanned = sc.nextLine();
                    headerArray[i] = scanned;
                    if (scanned.equals("<>")) {
                        startArray[i] = "<" + i + ">";
                    } else {
                        startArray[i] = scanned;
                    }
                    for (int j = 0; j < startArray.length; j++) tempArray[j] = startArray[j];
                }
                extendHeader();
            } else if (thisInput.equalsIgnoreCase("n")) {
                //init. empty header
                for (int i = 0; i < tempArray.length; i++) {
                    tempArray[i] = "<" + i + ">";
                    headerArray[i] = "<>";
                }
                System.out.println("A new header was created");
                createHeaderObject();
            }
        } else {
            System.out.println("No header exists. A new header was created.");
            //init. empty header
            for (int i = 0; i < tempArray.length; i++) {
                tempArray[i] = "<" + i + ">";
            }
            createHeaderObject();
        }
    }

>>>>>>> refs/remotes/origin/wip-leggetiljava
    void createHeaderObject() throws Exception {
        UserInput input = new UserInput();
        System.out.println("Current header:\n" + Arrays.toString(tempArray));
        System.out.println("Select position to start your " + cpt.getObjectContent());
<<<<<<< HEAD

        int position = input.getInt();

        if (!(position > tempArray.length)) {
            tempArray[position] = "<START>";
            System.out.println("Does <START> mark the correct starting point? [y/n]:\n" + Arrays.toString(tempArray));
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("y")) {
                correctStart(position);
            } else if (userInput.equalsIgnoreCase("n")) {
                for (int i = 0; i < tempArray.length; i++) {
                    tempArray[i] = "<" + i + ">";
                }
                createHeaderObject();
            } else {
                System.out.println("Invalid input, please try again!");
            }
        } else {
            System.out.println("The starting position must be between 0 and 11");
            createHeaderObject();
        }
    }

    void extendHeader() throws Exception {
        File headerFile = new File("./html_config/" + title + "_header.txt");
        Scanner scFile = new Scanner(headerFile);
        UserInput input = new UserInput();

        System.out.println("Current header:\n" + Arrays.toString(tempArray));
        System.out.println("Select position to start your " + cpt.getObjectContent());
        int position = input.getInt();
        if (!(position > tempArray.length)) {
            tempArray[position] = "<START>";
            System.out.println("Does <START> mark the correct starting point? [y/n]:\n" + Arrays.toString(tempArray));
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("y")) {
                correctStart(position);
            } else if (userInput.equalsIgnoreCase("n")) {
                for (int j = 0; j < startArray.length; j++) tempArray[j] = startArray[j];
                extendHeader();
            } else {
                System.out.println("Invalid input, please try again!");
            }
        } else {
            System.out.println("The starting position must be between 0 and 11");
            createHeaderObject();
        }
    }

    void correctStart(int position) throws Exception {
        UserInput input = new UserInput();
        System.out.println("Please define how many objects you want of the type " + cpt.getObjectContent());
        int size = input.getInt();
        while (!(size < 5)) {
            System.out.println("The maximum number of objects is 4");
            size = input.getInt();
        }
        int counter = 0;
        while (position < tempArray.length && counter < size) {
            tempArray[position] = cpt.getObjectContent();
            headerArray[position] = cpt.getObjectContent();
            position++;
            counter++;
        }
        System.out.println("This is your new header:\n" + Arrays.toString(tempArray));
        saveHeader();
        return;
    }

    void saveHeader() throws Exception {
        File txtFile = new File("./html_config/" + title + "_header.txt");
        txtFile.createNewFile();
=======

        int position = input.getInt();

        if (!(position > tempArray.length)) {
            tempArray[position] = "<START>";
            System.out.println("Does <START> mark the correct starting point? [y/n]:\n" + Arrays.toString(tempArray));
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("y")) {
                correctStart(position);
            } else if (userInput.equalsIgnoreCase("n")) {
                for (int i = 0; i < tempArray.length; i++) {
                    tempArray[i] = "<" + i + ">";
                }
                createHeaderObject();
            } else {
                System.out.println("Invalid input, please try again!");
            }
        } else {
            System.out.println("The starting position must be between 0 and 11");
            createHeaderObject();
        }
    }

    void extendHeader() throws Exception {
        File headerFile = new File("header.txt");
        Scanner scFile = new Scanner(headerFile);
        UserInput input = new UserInput();

        System.out.println("Current header:\n" + Arrays.toString(tempArray));
        System.out.println("Select position to start your " + cpt.getObjectContent());
        int position = input.getInt();
        if (!(position > tempArray.length)) {
            tempArray[position] = "<START>";
            System.out.println("Does <START> mark the correct starting point? [y/n]:\n" + Arrays.toString(tempArray));
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("y")) {
                correctStart(position);
            } else if (userInput.equalsIgnoreCase("n")) {
                for (int j = 0; j < startArray.length; j++) tempArray[j] = startArray[j];
                extendHeader();
            } else {
                System.out.println("Invalid input, please try again!");
            }
        } else {
            System.out.println("The starting position must be between 0 and 11");
            createHeaderObject();
        }
    }

    void correctStart(int position) throws Exception {
        UserInput input = new UserInput();
        System.out.println("Please define the size of your " + cpt.getObjectContent());
        int size = input.getInt();
        while (!(size < 5)) {
            System.out.println("The maximum object size is 4");
            size = input.getInt();
        }
        int counter = 0;
        while (position < tempArray.length && counter < size) {
            tempArray[position] = cpt.getObjectContent();
            headerArray[position] = cpt.getObjectContent();
            position++;
            counter++;
        }
        System.out.println("This is your new header:\n" + Arrays.toString(tempArray));
        saveHeader();
        return;
    }

    void saveHeader() throws Exception {
        File headerFile = new File("header.txt");

>>>>>>> refs/remotes/origin/wip-leggetiljava
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to save your header [y/n]");
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("y")) {
<<<<<<< HEAD
            PrintWriter txt = new PrintWriter(txtFile);
            for (int i = 0; i < headerArray.length; i++) {
                txt.println(headerArray[i]);
            }
            txt.close();
            System.out.println("Your header was successfully saved");
=======
            headerFile.createNewFile();
            PrintWriter print = new PrintWriter("header.txt");
            for (int i = 0; i < headerArray.length; i++) {
                // if (headerArray[i] != "<>") {
                print.println(headerArray[i]);
                //}
            }
            print.close();
            System.out.println("Your header was successfully saved to the file \"header.txt\" ");
>>>>>>> refs/remotes/origin/wip-leggetiljava
        } else if (input.equalsIgnoreCase("n")) {
            System.out.println("Your new header was not saved.");
        }
    }
}