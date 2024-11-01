package lotto.exception;

import lotto.constant.LottoErrorMessages;

public class BonusNumberDuplicateException extends LottoException {
    public BonusNumberDuplicateException() {
        super(LottoErrorMessages.BONUS_NUMBER_DUPLICATE.getMessage());
    }
}
