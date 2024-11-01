package lotto.service;

import static lotto.util.Constants.DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {
    public static List<Integer> splitWinningNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(DELIMITER.getStringValue());
        return Arrays.stream(numbers)
                .filter(num -> !num.trim().isEmpty())
                .map(num -> Parser.parseNumber(num.trim()))
                .collect(Collectors.toList());
    }
}