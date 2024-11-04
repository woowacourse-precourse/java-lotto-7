package lotto.util;

import java.util.Arrays;
import java.util.List;

public class ParseUtil {
    private static final String WINNING_NUMBER_DELIMITER = ",";

    private final ValidateUtil validateUtil;

    public ParseUtil() {
        this.validateUtil = new ValidateUtil();
    }

    public Integer parsePurchaseAmount(final String input) {
        validateUtil.validateNumber(input);
        final int purchaseAmount = Integer.parseInt(input);
        validateUtil.validateAmount(purchaseAmount);
        return purchaseAmount;
    }

    public List<Integer> parseWinningNumbers(final String input) {
        validateUtil.validateWinningNumbers(input);
        final List<Integer> winningNumbers = Arrays.stream(input.split(WINNING_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .toList();
        winningNumbers.forEach(validateUtil::validateRange);
        return winningNumbers;
    }

    public Integer parseBonusNumber(final String input, final List<Integer> winningNumbers) {
        validateUtil.validateBonusNumber(input, winningNumbers);
        return Integer.parseInt(input);
    }
}
