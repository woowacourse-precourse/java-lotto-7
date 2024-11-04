package lotto.validator.entity;

import lotto.enums.ExceptionMessage;
import lotto.validator.Validator;

// 보너스 번호 검증 클래스
public class BonusNumberValidator implements Validator {
    private final String bonusNumber;

    public BonusNumberValidator(String bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    @Override
    public void validate() {
        isNull();
        isValidatedForm();
        isInRange();
    }

    private void isValidatedForm() {
        if (!bonusNumber.matches("[0-9]+")) {
            printErrorMessageAndThrowError(ExceptionMessage.BONUS_NUMBER_NOT_VALID_FORMAT.getMessage());
        }
    }

    private void isNull() {
        if (bonusNumber == null) {
            printErrorMessageAndThrowError(ExceptionMessage.BONUS_NUMBER_IS_NULL.getMessage());
        }
    }

    private void isInRange() {
        try {
            int number = Integer.parseInt(bonusNumber);

            if (number < 1 || number > 45) {
                throw new Exception();
            }
        } catch (Exception e) {
            printErrorMessageAndThrowError(ExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}