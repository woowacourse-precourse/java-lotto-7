package lotto;

public class ErrorHandler {
    public static void throwException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}