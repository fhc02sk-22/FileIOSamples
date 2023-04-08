package org.campus02.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {

    private String path;

    public Logger(String path) {
        this.path = path;
    }

    private void logMessage(ErrorMessage message) {
        try(PrintWriter pw = new PrintWriter(new FileWriter(path, true))) {
            pw.println(message.toLine());
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void log(String message, String level) {
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
                .format(Calendar.getInstance().getTime());

        ErrorMessage errorMessage = new ErrorMessage(level, message, timeStamp);
        logMessage(errorMessage);
    }

    public void logFatal(String message) {
        log(message, "FATAL");
    }

    public void logError(String message) {
        log(message, "ERROR");
    }

    public void logDebug(String message) {
        log(message, "DEBUG");
    }

    public void logInfo(String message) {
        log(message, "INFO");
    }



}
