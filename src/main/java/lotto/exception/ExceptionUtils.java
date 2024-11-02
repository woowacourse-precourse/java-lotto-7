package lotto.exception;

public class ExceptionUtils {
    public static Exception IllegalArgument(ExceptionMessage message) {
        return new IllegalArgumentException(message.getMessage());
    }

    public static Exception IllegalArgumentWithCause(ExceptionMessage message, Throwable cause) {
        return new IllegalArgumentException(message.getMessage(), cause);
    }
}
