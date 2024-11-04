package lotto.validator;

import lotto.enums.ErrorMessages;

public class BonusNumberValidator {
    WinningNumberValidator winningNumberValidator = new WinningNumberValidator();

    public int validateBonusNumber(String bonusNumberInput, String winningNumber) {
        try {
            int bonusNumber = Integer.parseInt(bonusNumberInput);
            if (winningNumberValidator.validateNumberRange(bonusNumber)) {
                throw new IllegalArgumentException(
                        ErrorMessages.printError(ErrorMessages.ERROR_NUMBER_UNDER_ZERO_OVER_FORTY_FIVE));
            }
            if (!containsWinningNumbers(bonusNumber, winningNumber)) {
                throw new IllegalArgumentException(
                        ErrorMessages.printError(ErrorMessages.ERROR_BONUS_NUMBER_IS_NOT_EQUAL_WINNING_NUMBER));
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_BONUS_NUMBER_IS_NOT_STRING));
        }
    }

    private boolean containsWinningNumbers(int bonusNumber, String winningNumber) {
        for (Integer number : winningNumberValidator.splitLottoNumber(winningNumber)) {
            if (bonusNumber == number) {
                return false;
            }
        }
        return true;
    }




}
