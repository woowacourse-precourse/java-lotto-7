package lotto.service;

import lotto.global.string.ErrorConstants;

public class LottoService {
    private int money;

    public int getAmount(int money) {
        validateAmountIsMultipleOfThousand(money);
        this.money = money;
        return money / 1000;
    }

    private void validateAmountIsMultipleOfThousand(int money) {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorConstants.THOUSAND_UNITS_ERROR_MSG);
        }
    }

}
