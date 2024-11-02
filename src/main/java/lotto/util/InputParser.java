package lotto.util;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class InputParser {

    public int parseBuy(String inputBuy) {
        ValidationUtils.validateBuyAmount(inputBuy);
        return Integer.parseInt(inputBuy);
    }

    public Set<Integer> parseWinningNumbers(String winningNumInput) {
        Set<Integer> numbers = Arrays.stream(winningNumInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new));
        ValidationUtils.validateWinningNumbers(numbers);
        return numbers;
    }
}