package homework11.app;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    public String createFile(String path) {
        Path newFile ;
        try {
            newFile = Files.createFile(Path.of(path));
        } catch (FileAlreadyExistsException e){
            return  "File already exist!" ;
        } catch (IOException e){
            return "Something went wrong: " + e.getMessage();
        }

        return "Created " + newFile;
    }

    public String writeToFile(Path path, String content){
        try{
            Files.writeString(path, content);
        } catch (IOException e){
            return e.getMessage();
        }
        return "Recorded in " + path;
    }

    public String readFromFile(Path path){
        try {
            return Files.readString(path);
        } catch (IOException e){
            return e.getMessage();
        }
    }

}
