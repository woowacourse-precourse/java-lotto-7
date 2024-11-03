package lotto.exception;

public class LottoException {

    private static final String ERROR_START_PHRASES = "[ERROR] ";

    public static void throwIllegalArgumentException(String message) {
        throw new IllegalArgumentException(ERROR_START_PHRASES + message);
    }

    public static void throwIllegalArgumentException(String message, boolean isErrorTriggered) {
        if (isErrorTriggered) {
            throwIllegalArgumentException(message);
        }
    }

    public static void throwNumberFormatException(String message) {
        throw new IllegalArgumentException(ERROR_START_PHRASES + message);
    }

    public static void throwNumberFormatException(String message, boolean isErrorTriggered) {
        if (isErrorTriggered) {
            throwNumberFormatException(message);
        }
    }

}
