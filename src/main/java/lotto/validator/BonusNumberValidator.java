package lotto.validator;

import static lotto.validator.ValidatorUtils.BONUS_NUMBER_ERROR_MESSAGE;
import static lotto.validator.ValidatorUtils.isNumberInRange;

import java.util.List;

public class BonusNumberValidator implements Validator<Integer> {

    @Override
    public void validate(Integer bonusNumber) {
        validateBonusNumberRange(bonusNumber);
    }

    public void validateDuplicate(Integer bonusNumber, List<Integer> winningNumbers) {
        validate(bonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateBonusNumberRange(Integer bonusNumber) {
        if (!isNumberInRange(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE);
        }
    }
}
