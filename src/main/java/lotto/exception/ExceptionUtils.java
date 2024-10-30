package lotto.exception;

public class ExceptionUtils {
    public static void throwIllegalArgument(ExceptionMessage message) {
        throw new IllegalArgumentException(message.getMessage());
    }
}
