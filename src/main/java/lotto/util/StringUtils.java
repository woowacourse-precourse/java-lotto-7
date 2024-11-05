package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.exception.InvalidInputFormatException;

public class StringUtils {
    private static final String INPUT_DELIMITER = ",";

    public static List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(INPUT_DELIMITER))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new InvalidInputFormatException();
        }
    }

    public static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputFormatException();
        }
    }
}
