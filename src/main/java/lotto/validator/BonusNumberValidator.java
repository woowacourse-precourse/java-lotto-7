package lotto.validator;

import lotto.exception.LottoErrorMessage;
import lotto.exception.LottoException;
import lotto.model.Lotto;
import lotto.model.LottoConstants;

public class BonusNumberValidator {

    public void validateBonusNumber(Lotto lotto, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberNotInLotto(lotto, bonusNumber);
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new LottoException(LottoErrorMessage.OUT_OF_BONUS_NUMBER_RANGE);
        }
    }

    private boolean isOutOfRange(int bonusNumber) {
        return bonusNumber > LottoConstants.MAX_LOTTO_NUMBER.getValue()
                || bonusNumber < LottoConstants.MIN_LOTTO_NUMBER.getValue();
    }

    private void validateBonusNumberNotInLotto(Lotto lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new LottoException(LottoErrorMessage.BONUS_NUMBER_SAME_AS_WINNING_NUMBER);
        }
    }
}
