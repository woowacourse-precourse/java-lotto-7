package lotto.util;

import java.util.Arrays;
import java.util.List;

import static lotto.constants.LottoErrorMessage.INVALID_NUMBER_FORMAT;

public abstract class StringParser {

    private static final String SEPARATOR = ",";

    public static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public static List<Integer> toIntList(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(String::trim)
                .map(StringParser::toInt)
                .toList();
    }
}
