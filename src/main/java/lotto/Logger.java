package lotto;

public class Logger {
    public static void error(String message) {
        System.out.println(LogType.ERROR.prefix + " " + message);
    }
}
