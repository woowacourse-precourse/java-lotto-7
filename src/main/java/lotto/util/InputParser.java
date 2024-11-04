package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    public static int parsePurchasePrice(String input) {
        InputValidator.validatePurchasePrice(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> parseWinningNumbers(String input) {
        InputValidator.validateWinningNumbers(input);
        List<Integer> winningNumbers = new ArrayList<>();
        Arrays.stream(input.split(",")).forEach(
                num -> winningNumbers.add(Integer.parseInt(num)));
        return winningNumbers;
    }

    public static int parseBonusNumber(String input) {
        InputValidator.validateBonusNumber(input);
        return Integer.parseInt(input);
    }
}
