package lotto.util;

import java.util.List;
import java.util.stream.Stream;
import lotto.exception.NumberErrorCode;

public class ParseNumberUtil {
    private static final String NUMBER_SPLIT_SEPARATOR = ",";

    public static List<Integer> parseNumber(String numbers) {
        try {
            return Stream.of(numbers.split(NUMBER_SPLIT_SEPARATOR))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NumberErrorCode.NUMBER_PARSE_ERROR.getMessage());
        }
    }
}
