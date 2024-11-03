package lotto.validator;

import static lotto.constants.LottoConstants.LOTTO_MAX_NUMBER;
import static lotto.constants.LottoConstants.LOTTO_MIN_NUMBER;

import java.util.List;
import lotto.view.ErrorMessage;

public class BonusNumberValidator {

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateRange(bonusNumber);
        validateDuplication(bonusNumber, winningNumbers);
    }

    private static void validateRange(int bonusNumber) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private static void validateDuplication(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE_INVALID.getMessage());
        }
    }

}
