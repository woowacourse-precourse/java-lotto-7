package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static lotto.message.ErrorMessage.*;

public class SplitNumbers {
    private static final String DELIMITER_COMMA = ",";
    public static List<Integer> splitWinningNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(DELIMITER_COMMA))
                .map(String::trim)
                .map(SplitNumbers::validateDelimiter)
                .collect(Collectors.toList());
    }
    private static int validateDelimiter(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_WRONG_DELIMITER.getMessage());
        }
    }
}