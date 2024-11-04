package lotto.common.util;

import static lotto.common.constants.ExceptionMessages.INVALID_INPUT;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    private static final String DIGIT_REGEX = "^[0-9]+$";
    private static final String DELIMITER = ",";

    public static Integer toInteger(String value) {
        if (!value.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
        return Integer.parseInt(value);
    }

    public static List<Integer> splitByDelimiter(String value) {
        return Arrays.stream(value.split(DELIMITER))
                .map(StringParser::toInteger)
                .toList();
    }
}
