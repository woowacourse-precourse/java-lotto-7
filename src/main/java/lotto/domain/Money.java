package lotto.domain;

import static lotto.ErrorMessage.MONEY_UNIT_ERROR;
import static lotto.domain.LotteryMachine.LOTTO_PRICE;

public class Money {
    private final int paymentAmount;

    public Money(int paymentAmount) {
        validateMoneyUnit(paymentAmount);
        this.paymentAmount = paymentAmount;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    private void validateMoneyUnit(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format(MONEY_UNIT_ERROR.getMessage(), LOTTO_PRICE));
        }
    }
}
