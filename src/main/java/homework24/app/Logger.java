package homework24.app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static Logger instance;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String LOG_DIRECTORY = "src/main/java/homework24/logs/";
    private static final String LOG_FILE_PREFIX = "log-";
    private static final String LOG_FILE_EXTENSION = ".txt";
    private BufferedWriter writer;
    private LocalDate currentDate;

    private Logger(){
        try{
            this.currentDate = LocalDate.now();
            String logFileName = getLogFileName(currentDate);
            ensureLogDirExist();
            this.writer = new BufferedWriter(new FileWriter(logFileName, true));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static Logger getInstance(){
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void log (String typeOfLog, String message){
        try {
            LocalDate today =  LocalDate.now();
            if (!today.equals(currentDate)){
                rotateLogFile(currentDate);
            }

            String timeStamp = java.time.LocalDateTime.now().format(
                    java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            );
            writer.write(String.format("%s [%s] %s%n", timeStamp, typeOfLog.toUpperCase(), message));
            writer.flush();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    private String getLogFileName(LocalDate date) {
        return LOG_DIRECTORY + LOG_FILE_PREFIX + date.format(DATE_FORMAT) + LOG_FILE_EXTENSION;
    }

    private void ensureLogDirExist() throws IOException {
        if(!Files.exists(Paths.get(LOG_DIRECTORY))){
            Files.createDirectory(Paths.get(LOG_DIRECTORY));
        }
    }

    private void rotateLogFile(LocalDate newDate) throws IOException {
        writer.close();
        this.currentDate = newDate;
        String newLogFileName = getLogFileName(newDate);
        this.writer = new BufferedWriter(new FileWriter(newLogFileName, true));
    }


    public void close(){
        try {
            if (writer != null){
                writer.close();
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
