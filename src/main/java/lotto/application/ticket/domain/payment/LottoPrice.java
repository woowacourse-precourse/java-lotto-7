package lotto.application.ticket.domain.payment;


import static lotto.application.ticket.constants.Constants.BASIC_PRICE;
import static lotto.application.ticket.message.Message.NEED_MORE_MONEY;

import lotto.application.common.ThousandWons.ThousandWons;

public class LottoPrice {
    private final int amount;

    private LottoPrice(int amount) {
        this.amount = amount;
    }

    public static LottoPrice basic() {
        return new LottoPrice(BASIC_PRICE);
    }

    public void validateAffordable(ThousandWons money) {
        validateNotLessThanPrice(money.getValue());
    }

    private void validateNotLessThanPrice(int moneyAmount) {
        if (moneyAmount < amount) {
            throw new IllegalArgumentException(NEED_MORE_MONEY);
        }
    }

    public int calculateLottoCount(ThousandWons money) {
        return money.divide(amount);
    }

}
