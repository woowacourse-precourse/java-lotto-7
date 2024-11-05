package lotto.exception;

import static lotto.constant.LottoErrorMessages.BONUS_NUMBER_DUPLICATE;

public class BonusNumberDuplicateException extends LottoException {
    public BonusNumberDuplicateException() {
        super(BONUS_NUMBER_DUPLICATE);
    }
}
