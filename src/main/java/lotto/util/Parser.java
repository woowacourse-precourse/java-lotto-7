package lotto.util;

import java.util.List;
import java.util.stream.Stream;

public class Parser {
    public static final String WINNING_NUMBER_DELIMITER = ",";
    private static final String ERROR_NON_NUMERIC_INPUT = "[ERROR] 숫자만 입력 가능합니다.";

    public static Integer parseStringToInt(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC_INPUT);
        }
    }

    public static List<Integer> parseStringToList(String winningNumbers) {
        try {
            return Stream.of(winningNumbers.split(WINNING_NUMBER_DELIMITER))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC_INPUT);
        }
    }
}
