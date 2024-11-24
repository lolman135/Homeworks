package homework11.app;

import java.nio.file.Paths;

public class Main {

    private static final String BASE_PATH = "files/";

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        String fileName = "myfile";
        String content = "Super information.";
        String path = BASE_PATH + fileName + ".txt";
        getOutput(fileHandler.createFile(path));
        getOutput(fileHandler.writeToFile(Paths.get(path), content));
        getOutput(fileHandler.readFromFile(Paths.get(path)));
    }

    private static void getOutput(String message){
        System.out.println(message);
    }
}
