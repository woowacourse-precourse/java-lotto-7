package lotto.model.domain;

import static lotto.constant.LottoConstant.MAX_NUM;
import static lotto.constant.LottoConstant.MIN_NUM;
import static lotto.ui.error.LottoError.LOTTO_NUM_OUT_OF_RANGE_ERR;

public class BonusNumber {
    private int number;

    public BonusNumber(int number) {
        validateBonusNumberRange(number);
        this.number = number;
    }

    public int get() {
        return number;
    }

    private void validateBonusNumberRange(int bonusNumber) {
        boolean isInRange = bonusNumber >= MIN_NUM && bonusNumber <= MAX_NUM;

        if (!isInRange) {
            throw new IllegalArgumentException(LOTTO_NUM_OUT_OF_RANGE_ERR);
        }
    }
}
