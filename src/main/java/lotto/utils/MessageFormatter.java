package lotto.utils;

public class MessageFormatter {
    public static String formatErrorMessage(String messageTemplate, Object... args) {
        return ErrorMessages.ERROR + String.format(messageTemplate, args);
    }
    public static String formatMessage(String messageTemplate, Object... args) {
        return String.format(messageTemplate, args);
    }
}
