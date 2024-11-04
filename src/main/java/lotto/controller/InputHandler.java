package lotto.controller;

import java.util.function.Supplier;

public class InputHandler {

    private final ErrorHandler errorHandler;

    public InputHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    public <T> T retryOnError(Supplier<T> inputMethod) {
        while (true) {
            try {
                return inputMethod.get();
            } catch (IllegalArgumentException e) {
                errorHandler.accept(e);
            }
        }
    }
}
