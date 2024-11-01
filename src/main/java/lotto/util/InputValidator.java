package lotto.util;

import lotto.exception.LottoException;
import lotto.exception.LottoException.EmptyInputException;
import lotto.exception.LottoException.NotAllowCharacterInputException;
import lotto.exception.LottoException.NotAllowNegativeNumberException;
import lotto.view.InputView;

public class InputValidator {

    private static final int ZERO = 0;

    private InputValidator() {

    }

    public static void validateBuyLotteriesAmount(final String buyAmount) {
        validateEmptyInput(buyAmount);
        validateIsNumeric(buyAmount);
        validateNegativeNumber(buyAmount);
    }

    public static void validateWinningNumbers(final String winningNumber) {
        validateEmptyInput(winningNumber);
    }

    public static void validateBonusNumber(final String bonusNumber) {
        validateEmptyInput(bonusNumber);
    }

    protected static void validateEmptyInput(final String input) {
        if (input.isEmpty()) {
            throw new EmptyInputException();
        }
    }

    protected static void validateNegativeNumber(final String input) {
        if (!isPositiveNumber(input)) {
            throw new NotAllowNegativeNumberException();
        }
    }

    protected static void validateIsNumeric(final String input) {
        if (!isNumeric(input)) {
            throw new NotAllowCharacterInputException();
        }
    }

    private static boolean isNumeric(final String number) {
        try {
            Integer.valueOf(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isPositiveNumber(final String amount) {
        try {
            int numericAmount = Integer.parseInt(amount);
            return (numericAmount > ZERO);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
