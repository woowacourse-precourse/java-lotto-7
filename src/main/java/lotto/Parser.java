package lotto;

import java.util.Arrays;

public class Parser {
    private static final String WINNING_NUMBER_OPERATOR = ",";

    int purchaseAmount(String purchaseInput) {
        return Integer.parseInt(purchaseInput);
    }

    int[] winningNumbers(String winningNumbers) {
        return Arrays
            .stream(winningNumbers.split(WINNING_NUMBER_OPERATOR))
            .mapToInt(Integer::parseInt).toArray();
    }

    int bonusNumber(String bonusNumberInput) {
        return Integer.parseInt(bonusNumberInput);
    }
}
