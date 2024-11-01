package lotto.util;

import java.util.Arrays;
import java.util.List;

import static lotto.constants.LottoErrorMessage.INVALID_NUMBER_FORMAT;

public abstract class StringParser {

    public static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public static List<Integer> toIntList(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(StringParser::toInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
