package lotto.domain;

import lotto.Constant;
import lotto.validation.LottoValidator;

public class Attempt {
    private final int lottoAmount;
    private final int cashAmount;

    public Attempt(int cashAmount) {
        validate(cashAmount);
        this.cashAmount = cashAmount;
        this.lottoAmount = calLottoAmount(cashAmount);

    }

    private int calLottoAmount(int input) {
        return input / Constant.LOTTO_PRICE;
    }

    private void validate(int cashAmount) {
        LottoValidator.checkValidCashAmount(cashAmount);
    }

    //getter
    public int getLottoAmount() {
        return lottoAmount;
    }

    public int getCashAmount() {
        return cashAmount;
    }
}
