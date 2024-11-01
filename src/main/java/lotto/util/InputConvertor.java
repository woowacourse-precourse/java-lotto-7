package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.error.ErrorType;
import lotto.error.exception.InvalidNumberException;

public class InputConvertor {

    private InputConvertor() {

    }

    public static List<Integer> parseToNumbers(final String delimiter, final String input) {
        return Arrays.stream(input.split(delimiter))
                .map(InputConvertor::parseToInt)
                .toList();
    }

    public static int parseToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException(ErrorType.INVALID_NUMBER_FORMAT);
        }
    }
}
