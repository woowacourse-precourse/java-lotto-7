package lotto;

/**
 * ExceptionBuilder
 */
public class ExceptionBuilder {

    private static String prefix = "[ERROR]";

    public static IllegalArgumentException argumentException(String message, String arg) {
        String prettyMessage = String.format("%s %s (%s)", prefix, message, arg);
        return new IllegalArgumentException(prettyMessage);
    }

    public static IllegalStateException stateException(String message) {
        String prettyMessage = String.format("%s %s", prefix, message);
        return new IllegalStateException(prettyMessage);
    }

}
