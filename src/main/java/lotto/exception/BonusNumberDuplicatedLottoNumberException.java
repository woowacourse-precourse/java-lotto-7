package lotto.exception;

import static lotto.constants.ExceptionMessages.BONUS_NUMBER_DUPLICATED_LOTTO_NUMBER;

public class BonusNumberDuplicatedLottoNumberException extends IllegalArgumentException {
    public BonusNumberDuplicatedLottoNumberException() {
        super(BONUS_NUMBER_DUPLICATED_LOTTO_NUMBER);
    }
}
