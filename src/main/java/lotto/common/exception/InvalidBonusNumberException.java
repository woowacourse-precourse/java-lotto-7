package lotto.common.exception;

import lotto.domain.lotto.LottoNumber;

public class InvalidBonusNumberException extends LottoException {
    public InvalidBonusNumberException(LottoNumber bonusNumber) {
        super(ErrorMessage.BONUS_NUMBER_MUST_NOT_BE_IN_WINNING_LOTTO + "(보너스 번호: " + bonusNumber.getLottoNumber() + ")");
    }

    public InvalidBonusNumberException(LottoNumber bonusNumber, Exception e) {
        super(ErrorMessage.BONUS_NUMBER_MUST_NOT_BE_IN_WINNING_LOTTO + "(보너스 번호: " + bonusNumber.getLottoNumber() + ")", e);
    }
}
