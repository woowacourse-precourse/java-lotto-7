package lotto.parse;

import static lotto.constants.LottoConstants.DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public static int getParsedPurchaseAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> getParsedWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
