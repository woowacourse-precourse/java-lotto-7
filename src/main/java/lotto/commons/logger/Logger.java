package lotto.commons.logger;

import java.util.Arrays;
import lotto.commons.util.Collections;

public class Logger {

    private Logger() {}

    private static final String TXT_COLOR_RED = "\u001B[31m";
    private static final String TXT_COLOR_RESET = "\u001B[0m";

    private static final String INFO_PREFIX = "[INFO]";
    private static final String ERROR_PREFIX = "[ERROR]";

    public static void info(String message) {
        if (message.startsWith(INFO_PREFIX)) {
            System.out.println(message);
            return;
        }
        System.out.println(INFO_PREFIX + " " +message);
    }

    public static void error(String error) {
        if (error.startsWith(ERROR_PREFIX)) {
            printError(error);
            return;
        }
        printError(ERROR_PREFIX + " " + error);
    }

    public static void error(Throwable t) {
        String content = t.getMessage();
        content += "\n";
        content += Collections.joinToString(Arrays.asList(t.getStackTrace()), "\n");
        Logger.error(content);
    }

    private static void printError(String message) {
        System.out.println(TXT_COLOR_RED + message + TXT_COLOR_RESET);
    }
}
