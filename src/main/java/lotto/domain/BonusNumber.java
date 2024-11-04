package lotto.domain;

import lotto.utils.ValidatorFactory;
import lotto.validation.Validator;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    public BonusNumber(int number, WinningNumbers winningNumbers) {
        ValidatorFactory.validateWinningNumbersState(winningNumbers);

        validateBonusNumber(number, winningNumbers);
        this.number = number;
    }

    private void validateBonusNumber(int number, WinningNumbers winningNumbers) {
        validateRange(number);
        validateNonDuplicate(number, winningNumbers);
    }

    private void validateRange(int number) {
        Validator<Integer> rangeValidator = ValidatorFactory.createNumberRangeValidator(MIN_NUMBER, MAX_NUMBER);
        rangeValidator.validate(number);
    }

    private void validateNonDuplicate(int number, WinningNumbers winningNumbers) {
        Validator<WinningNumbers> nonDuplicateValidator = ValidatorFactory.createBonusNumberValidator(number);
        nonDuplicateValidator.validate(winningNumbers);
    }

    public int getNumber() {
        return number;
    }
}
