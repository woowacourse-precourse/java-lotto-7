package lotto.util.validator;

import static lotto.util.Constants.LOTTO_MAX_RANGE;
import static lotto.util.Constants.LOTTO_MIN_RANGE;

import lotto.model.lotto.Lotto;
import lotto.util.ExceptionMessage;

public class BonusValidator extends AbstractValidator{

    @Override
    protected void performSpecificValidation(String input) {
        int BonusValue = Integer.parseInt(input);
        validateBonusNumberRange(BonusValue);

    }
    private void validateBonusNumberRange(int number) {
        if (number < LOTTO_MIN_RANGE || number > LOTTO_MAX_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_LOTTO_RANGE.getMessage());
        }
    }
    /*public void validateDuplicates(String bonusNumber, Lotto lotto) {
        if (lotto.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }*/

}
