package org.campus02.log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogDemoApp {
    public static void main(String[] args) {

        String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
                .format(Calendar.getInstance().getTime());


        /*ErrorMessage em = new ErrorMessage("ERROR", "Test-Fehler"
                , timeStamp);*/

        Logger logger = new Logger("D:\\temp\\log_20210324.log");

        logger.logFatal("Fataler Fehler - BlueScreen");
        logger.logError("Normaler Fehler - Programm stürzt ab");
        logger.logDebug("Eine Debug-Meldung");
        logger.logInfo("Eine Info-Meldung");

        System.out.println("finished");
    }
}
