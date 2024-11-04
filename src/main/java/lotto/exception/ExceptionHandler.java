package lotto.exception;

public class ExceptionHandler {
    public static void throwIllegalArgException(ErrorMessage error) {
        throw new IllegalArgumentException(error.getMessage());
    }

    public static void throwIllegalStateException(ErrorMessage error) {
        throw new IllegalStateException(error.getMessage());
    }
}
