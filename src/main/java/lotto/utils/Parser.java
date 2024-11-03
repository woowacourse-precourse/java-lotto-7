package lotto.utils;

import lotto.exception.ParserException;
import lotto.exception.message.ParserExceptionMessage;

public final class Parser {

    private Parser() {
    }

    public static int parseStringToInt(String input) {
        validateIsEmpty(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new ParserException(ParserExceptionMessage.NOT_NUMBER);
        }
    }

    private static void validateIsEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new ParserException(ParserExceptionMessage.EMPTY_INPUT);
        }
    }
}
