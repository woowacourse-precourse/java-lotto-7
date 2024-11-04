package lotto.model.administrator;

import static lotto.util.LottoConstant.LOTTO_NUMBER_END_WITH;
import static lotto.util.LottoConstant.LOTTO_NUMBER_START_WITH;

import lotto.exception.administrator.OutOfRangeLottoNumberException;

public class LottoBonusNumber {

    private final int bonusNumber;

    public LottoBonusNumber(final int bonusNumber) {
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateRange(final int number) {
        if (number < LOTTO_NUMBER_START_WITH.getNumber() ||
                number > LOTTO_NUMBER_END_WITH.getNumber()) {
            throw new OutOfRangeLottoNumberException();
        }
    }
}
