package lotto.domain;

import lotto.utils.ValidatorFactory;
import lotto.validation.Validator;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    public BonusNumber(int number, WinningNumbers winningNumbers) {
        Validator<Integer> rangeValidator = ValidatorFactory.createNumberRangeValidator(
                MIN_NUMBER, MAX_NUMBER, "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
        );
        Validator<WinningNumbers> nonDuplicateValidator = ValidatorFactory.createBonusNumberValidator(number,
                "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");

        rangeValidator.validate(number);
        nonDuplicateValidator.validate(winningNumbers);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
