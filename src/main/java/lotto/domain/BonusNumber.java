package lotto.domain;

import lotto.ErrorCode;

public class BonusNumber {
    private final Integer bonusNumber;
    private static final Integer LOTTO_START_NUMBER = 1;
    private static final Integer LOTTO_END_NUMBER = 45;


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
        if (!(bonusNumber >= LOTTO_START_NUMBER && bonusNumber <= LOTTO_END_NUMBER)) {
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
