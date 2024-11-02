package lotto.commons.logger;

public class Logger {

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
            System.err.println(error);
            return;
        }
        System.err.println(ERROR_PREFIX + " " + error);
    }

    public static void error(Throwable t) {
        Logger.error(t.getMessage());
    }
}
