package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {
    public static List<Integer> splitWinningNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");
        return Arrays.stream(numbers)
                .filter(num -> !num.trim().isEmpty())
                .map(num -> Parser.toInt(num.trim()))
                .collect(Collectors.toList());
    }
}