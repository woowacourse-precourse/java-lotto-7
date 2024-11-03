package lotto.aop;

import lotto.io.OutputHandler;

public class RetryHandler {

    private final OutputHandler outputHandler;

    public RetryHandler(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public <T> T tryUntilSuccess(final IllegalArgumentExceptionThrower<T> thrower) {
        while (true) {
            try {
                return thrower.run();
            } catch (IllegalArgumentException illegalArgumentException) {
                outputHandler.handleExceptionMessage(illegalArgumentException);
            } catch (Exception exception) {
                outputHandler.handleExceptionMessage(exception);
                throw exception;
            }
        }
    }

    @FunctionalInterface
    public interface IllegalArgumentExceptionThrower<T> {
        T run() throws IllegalArgumentException;
    }
}
