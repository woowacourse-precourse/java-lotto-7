package lotto.exception;

public class ExceptionUtils {
    public static IllegalArgumentException IllegalArgument(ExceptionMessage message) {
        return new IllegalArgumentException(message.getMessage());
    }

    public static IllegalArgumentException IllegalArgumentWithCause(ExceptionMessage message, Throwable cause) {
        return new IllegalArgumentException(message.getMessage(), cause);
    }
}
