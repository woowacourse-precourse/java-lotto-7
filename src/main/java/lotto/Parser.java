package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private static final String WINNING_NUMBER_OPERATOR = ",";

    int purchaseAmount(String purchaseInput) {
        return Integer.parseInt(purchaseInput);
    }

    List<Integer> winningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(WINNING_NUMBER_OPERATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    int bonusNumber(String bonusNumberInput) {
        return Integer.parseInt(bonusNumberInput);
    }
}
