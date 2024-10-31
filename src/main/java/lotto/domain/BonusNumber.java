package lotto.domain;

import lotto.constant.ExceptionConstant;
import lotto.constant.LottoConstant;

public class BonusNumber {
    int bonus;

    public BonusNumber(int bonus) {
        bonusValidate(bonus);
        this.bonus = bonus;
    }

    private void bonusValidate(int bonus) {
        if (!(bonus >= LottoConstant.LOTTO_NUMBER_MIN && bonus <= LottoConstant.LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException(ExceptionConstant.NUMBER_VALID_RANGE);
        }
    }
}
