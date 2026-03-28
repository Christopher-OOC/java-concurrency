package org.javalord.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LoggerUtil {

    public static void setUpLogger() {
        Logger rootLogger = Logger.getLogger("");
        for (Handler handler : rootLogger.getHandlers()) {
            handler.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord record) {
                    String time = new SimpleDateFormat("HH:mm:ss").format(new Date(record.getMillis()));

                    return String.format(
                            "%s [%s] %s - %s%n",
                            time,
                            Thread.currentThread().getName(),
                            record.getLevel(),
                            record.getMessage()
                    );
                }
            });
        }
    }
}
