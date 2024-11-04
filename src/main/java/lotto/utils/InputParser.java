package lotto.utils;

import lotto.model.domain.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final String SPLIT_DELIMITER = ",";

    private InputParser() {}

    public static WinningNumbers parseWinningNumbers(String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(SPLIT_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new WinningNumbers(winningNumbers);
    }

    public static int parseNumber(String input) {
        InputValidator.validateInputValue(input);
        return Integer.parseInt(input.trim());
    }
}
