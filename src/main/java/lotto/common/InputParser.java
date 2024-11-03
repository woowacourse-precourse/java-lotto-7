package lotto.common;

import static lotto.exception.constants.ErrorMessage.INVALID_INPUT_TEXT;

import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoException;

public class InputParser {

    private static final String COMMA_DELIMITER = ",";
    private static final int DEFAULT_LIMIT = -1;

    public static Integer parseInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoException(INVALID_INPUT_TEXT.getMessage());
        }
    }

    public static List<Integer> parseIntegers(final String input) {
        return Arrays.stream(input.split(COMMA_DELIMITER, DEFAULT_LIMIT))
                .map(String::trim)
                .map(InputParser::parseInteger)
                .toList();
    }
}
