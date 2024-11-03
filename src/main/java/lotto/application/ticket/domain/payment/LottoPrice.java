package lotto.application.ticket.domain.payment;


import lotto.application.common.ThousandWons.ThousandWons;

public class LottoPrice {
    public final static int BASIC_PRICE = 1000;
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
            throw new IllegalArgumentException("[ERROR] 구매 가능한 금액이 부족합니다.");
        }
    }

    public int calculateLottoCount(ThousandWons money) {
        return money.divide(amount);
    }

}
