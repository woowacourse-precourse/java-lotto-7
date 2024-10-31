package lotto;

public class ErrorHandler {
    public static void printAndThrow(String message) {
        Printer.printErrorMessage(message);
        throwException();
    }

    private static void throwException() {
        throw new IllegalArgumentException();
    }
}