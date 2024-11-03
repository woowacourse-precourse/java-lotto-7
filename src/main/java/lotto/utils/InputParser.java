package lotto.utils;

import static lotto.constants.LottoConstants.DELIMITER;
import static lotto.constants.LottoConstants.PURCHASE_UNIT_WON;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public static int parsePurchaseAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / PURCHASE_UNIT_WON;
    }

    public static List<Integer> parseWinningNumber(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int parseBonusNumber(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }
}
