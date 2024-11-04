package lotto.exception;

public class printException {
    public static void throwIllegalArgException(ErrorMessage error) {
        throw new IllegalArgumentException(error.getErrorMessage());
    }
}
