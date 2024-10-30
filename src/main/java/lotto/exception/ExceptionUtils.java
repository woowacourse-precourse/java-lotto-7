package lotto.exception;

public class ExceptionUtils {
    public static void ThrowIllegalArgumentException(ExceptionMessage message) {
        throw new IllegalArgumentException(message.getMessage());
    }
}
