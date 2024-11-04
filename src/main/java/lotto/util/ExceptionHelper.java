package lotto.util;

public class ExceptionHelper {
    private ExceptionHelper() {
    }

    public static String errorMessage(final String message) {
        return "[ERROR] " + message;
    }
}
