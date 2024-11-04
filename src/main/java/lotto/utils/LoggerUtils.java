package lotto.utils;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtils {

    private static final Logger logger = Logger.getLogger(LoggerUtils.class.getName());

    static {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());
        consoleHandler.setLevel(Level.INFO);
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);
    }

    private LoggerUtils() {}

    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    public static void logError(String message) {
        logger.log(Level.SEVERE, message);
    }
}