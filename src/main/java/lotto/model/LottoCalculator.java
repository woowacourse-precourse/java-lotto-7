package lotto.model;

import static lotto.Constants.LOTTO_PRICE;

public class LottoCalculator {

    private int payment;

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getLottoAmount() {
        return payment / LOTTO_PRICE;
    }
}
