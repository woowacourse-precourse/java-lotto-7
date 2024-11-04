package lotto.exception;

import lotto.console.ConsoleManager;

public class InputException extends IllegalArgumentException{
    public InputException(final ExceptionMessage message) {
        ConsoleManager.println(message.getMessage());
    }
}
