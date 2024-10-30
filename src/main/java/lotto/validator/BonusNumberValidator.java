package lotto.validator;

import lotto.domain.Lotto;
import lotto.validator.exception.ErrorMessage;
import lotto.validator.exception.LottoException;

public class BonusNumberValidator {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static void validateProcess(int bonusNumber, Lotto winningLotto) {
        validateRange(bonusNumber);
        validateDuplicate(bonusNumber, winningLotto);
    }

    private static void validateRange(int bonusNumber) {
        if(bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw LottoException.from(ErrorMessage.BONUS_NUMBER_RANGE_ERROR);
        }
    }

    private static void validateDuplicate(int bonusNumber, Lotto winningLotto) {
        if(winningLotto.getNumbers().contains(bonusNumber)) {
            throw LottoException.from(ErrorMessage.BONUS_NUMBER_DUPLICATE_WINNING_LOTTO);
        }
    }
}
