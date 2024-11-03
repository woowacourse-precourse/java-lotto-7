package lotto.domain;

import lotto.ErrorCode;

public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(String bonusNumber, WinningNumber winningNumber) {
        validate(bonusNumber, winningNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validate(String bonusNumber, WinningNumber winningNumber) throws IllegalArgumentException {
        validateInputNumeric(bonusNumber);
        validateBonusNumberInRange(bonusNumber);
        validateBonusNumberDuplicate(bonusNumber, winningNumber);
    }

    private void validateInputNumeric(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorCode.INPUT_POSITIVE_INTEGER.getErrorMessage());
        }
    }

    private void validateBonusNumberInRange(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (!(bonusNumber > 0 && bonusNumber < 46)) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_IN_RANGE.getErrorMessage());
        }
    }

    private void validateBonusNumberDuplicate(String input, WinningNumber winningNumber) {
        int bonusNumber = Integer.parseInt(input);
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_DUPLICATE.getErrorMessage());
        }
    }
}
