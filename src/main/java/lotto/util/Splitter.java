package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Splitter {
    private static final String DELIMITER = ",";

    public static List<Integer> splitWinningNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(DELIMITER);
        return Arrays.stream(numbers)
                .filter(num -> !num.trim().isEmpty())
                .map(num -> Parser.parseNumber(num.trim()))
                .toList();
    }
}