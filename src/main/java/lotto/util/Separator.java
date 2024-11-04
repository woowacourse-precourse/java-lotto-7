package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Separator {

    private static final String DEFAULT_DELIMITER  = ",";

    public static String[] splitWithComma(String str) {
        return str.split(DEFAULT_DELIMITER);
    }

    public static List<Integer> splitWithCommaToInteger(String str) {
        return Arrays.stream(splitWithComma(str))
                .map(Separator::parseInteger)
                .collect(Collectors.toList());
    }

    private static Integer parseInteger(String numberStr) {
        try {
            return Integer.parseInt(numberStr.trim()); // Trim whitespace
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE_INT.getMessage());
        }
    }

}
