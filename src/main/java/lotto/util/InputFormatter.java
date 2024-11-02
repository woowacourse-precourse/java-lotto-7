package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;

public class InputFormatter {

    private static final String DELIMITER = ",";

    public int formatMoneyInput(String moneyInput) {
        validateMoneyFormat(moneyInput);
        return Integer.parseInt(moneyInput);
    }

    public List<Integer> formatWinningNumbersInput(String winningNumbersInput) {
        validateWinningNumbersFormat(winningNumbersInput);
        return formatWinningNumbers(winningNumbersInput);
    }

    public int formatBonusNumberInput(String bonusNumberInput) {
        validateBonusNumberFormat(bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }

    private void validateMoneyFormat(String moneyInput) {
        try {
            Integer.parseInt(moneyInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_FORMAT_WRONG.toString());
        }
    }

    private void validateWinningNumbersFormat(String winningNumbersInput) {
        try {
            formatWinningNumbers(winningNumbersInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_FORMAT_WRONG.toString());
        }
    }

    private void validateBonusNumberFormat(String bonusNumberInput) {
        try {
            Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_FORMAT_WRONG.toString());
        }
    }

    private List<Integer> formatWinningNumbers(String winningNumbersInput) {
        return Arrays.stream(winningNumbersInput.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
