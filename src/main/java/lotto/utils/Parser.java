package lotto.utils;

import java.util.Arrays;
import java.util.List;
import lotto.exception.ParserException;
import lotto.exception.message.ParserExceptionMessage;

public final class Parser {

    private static final String SEPARATOR = ",";

    private Parser() {
    }

    public static int parseStringToInt(String input) {
        validateIsEmpty(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            if (input.matches("-?\\d+")) {
                throw new ParserException(ParserExceptionMessage.NUMBER_OUT_OF_RANGE);
            }
            throw new ParserException(ParserExceptionMessage.NOT_NUMBER);
        }
    }


    public static List<Integer> splitBySeparator(String input){
        return Arrays.stream(input.split(SEPARATOR, -1))
                .map(Parser::parseStringToInt)
                .toList();
    }

    private static void validateIsEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new ParserException(ParserExceptionMessage.EMPTY_INPUT);
        }
    }
}
