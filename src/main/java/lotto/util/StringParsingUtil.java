package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.common.ErrorMessage;

public final class StringParsingUtil {

    private static final String NUMBER_LIST_PATTERN = "^\\s*\\d+(\\s*,\\s*\\d+)*\\s*$";
    private static final String COMMA_SEPARATOR = ",";

    private StringParsingUtil() {
        throw new IllegalStateException(ErrorMessage.UTILITY_CLASS_INSTANTIATION.getMessage());
    }

    public static List<Integer> parseNumbers(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY.getMessage());
        }

        if (!input.matches(NUMBER_LIST_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }

        return Arrays.stream(input.split(COMMA_SEPARATOR))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
