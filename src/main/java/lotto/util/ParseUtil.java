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
        validateUtil.validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

    public List<Integer> parseWinningNumbers(final String input) {
        validateUtil.validateWinningNumbers(input);
        return Arrays.stream(input.split(WINNING_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public Integer parseBonusNumber(final String input, final List<Integer> winningNumbers) {
        validateUtil.validateBonusNumber(input, winningNumbers);
        return Integer.parseInt(input);
    }
}
