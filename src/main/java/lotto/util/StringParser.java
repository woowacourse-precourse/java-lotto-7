package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.error.Error;

public class StringParser {

    public int parseStringToInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(Error.WRONG_NUMBER_FORMAT_ERROR.getMessage());
        }
    }

    public List<Integer> parseStringToNumbers(String string, String delimiter) {
        String[] splitStrings = string.split(delimiter);
        return Arrays.stream(splitStrings)
                .map(this::parseStringToInteger)
                .toList();
    }

}
