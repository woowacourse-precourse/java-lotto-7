package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.common.ErrorMessage;

public final class StringParsingUtil {

    private StringParsingUtil() {
        throw new IllegalStateException(ErrorMessage.UTILITY_CLASS_INSTANTIATION.getMessage());
    }

    public static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
