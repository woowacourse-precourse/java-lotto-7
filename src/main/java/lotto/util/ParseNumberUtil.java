package lotto.util;

import java.util.List;
import java.util.stream.Stream;
import lotto.exception.NumberErrorCode;

public class ParseNumberUtil {
    private static final String NUMBER_SPLIT_SEPARATOR = ",";

    public static List<Integer> parseNumber(String numbers) {
        if (isEmpty(numbers) || isFormatError(numbers)) {
            throw new IllegalArgumentException(NumberErrorCode.NUMBER_PARSE_ERROR.getMessage());
        }

        try {
            return Stream.of(numbers.split(NUMBER_SPLIT_SEPARATOR))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NumberErrorCode.NUMBER_PARSE_ERROR.getMessage());
        }
    }

    private static boolean isFormatError(String numbers) {
        return numbers.endsWith(NUMBER_SPLIT_SEPARATOR) || numbers.startsWith(NUMBER_SPLIT_SEPARATOR);
    }

    private static boolean isEmpty(String numbers) {
        return numbers.trim().isEmpty();
    }

    public static Integer parseNumberToInteger(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NumberErrorCode.NUMBER_PARSE_ERROR.getMessage());
        }
    }
}
