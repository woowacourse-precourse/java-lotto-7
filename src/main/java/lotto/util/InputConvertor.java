package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.error.ErrorMessage;
import lotto.error.exception.InvalidNumberException;

public class InputConvertor {

    private static final int SPLIT_LIMIT = -1;

    private InputConvertor() {

    }

    public static List<Integer> parseToNumbers(final String delimiter, final String input) {
        return Arrays.stream(input.split(delimiter, SPLIT_LIMIT))
                .map(InputConvertor::parseToInt)
                .toList();
    }

    public static int parseToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }
}
