package lotto.commons.logger;

public class Logger {

    public static void error(String error) {
        System.err.println("[ERROR] " + error);
    }

    public static void error(Throwable t) {
        Logger.error(t.getMessage());
    }
}
