package lotto.exception;

public class ExceptionHandler {
    public static void handleIllegalArgumentException(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
