package lotto.utils.validator;

import static lotto.utils.Constant.MAX_LOTTO_NUMBER;
import static lotto.utils.Constant.MIN_LOTTO_NUMBER;
import static lotto.utils.ErrorMessage.BONUS_NUMBER_ERROR_MESSAGE;

import java.util.List;

public class BonusNumberValidator extends Validator {

    @Override
    public void validate(String userInput) {
        validateEmpty(userInput);
        validateNumber(userInput, BONUS_NUMBER_ERROR_MESSAGE.toString());
    }

    public void validateNumberInRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE.toString());
        }
    }

    public void validateDuplicateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE.toString());
        }
    }
}
