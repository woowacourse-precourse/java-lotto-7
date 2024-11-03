package lotto.validator;

import static lotto.validator.ValidatorUtils.BONUS_NUMBER_ERROR_MESSAGE;
import static lotto.validator.ValidatorUtils.isNumberInRange;

public class BonusNumberValidator implements Validator<Integer> {

    @Override
    public void validate(Integer bonusNumber) {
        validateBonusNumberRange(bonusNumber);
    }

    private void validateBonusNumberRange(Integer bonusNumber) {
        if (!isNumberInRange(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE);
        }
    }
}
