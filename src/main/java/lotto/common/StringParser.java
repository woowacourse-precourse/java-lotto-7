package lotto.common;

import java.util.Arrays;
import java.util.List;

import lotto.constant.ErrorMessage;

public class StringParser {
    public static final String LOTTO_NUMBER_INPUT_DELIMITER = ",";

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
        }
    }

    public static List<Integer> parseIntListByComma(String input) {
        return Arrays.stream(input.split(LOTTO_NUMBER_INPUT_DELIMITER, -1)).map(StringParser::parseInt).toList();
    }
}
