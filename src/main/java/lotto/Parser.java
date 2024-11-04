package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private static final String WINNING_NUMBER_OPERATOR = ",";

    int parsePurchaseAmount(String purchaseInput) {
        return Integer.parseInt(purchaseInput);
    }

    List<Integer> parseWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(WINNING_NUMBER_OPERATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    int parseBonusNumber(String bonusNumberInput) {
        return Integer.parseInt(bonusNumberInput);
    }
}
