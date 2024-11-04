package lotto.utils.converter;

import java.util.Arrays;
import java.util.List;
import lotto.utils.ErrorMessages;

public class WinningNumberConverter {
    private static final String DELIMITER = ",";

    private WinningNumberConverter() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static List<Integer> convert(String input) {
        try {
            return Arrays.stream(input.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NON_INTEGER_LOTTO_NUMBER);
        }
    }

}
