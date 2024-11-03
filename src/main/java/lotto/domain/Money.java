package lotto.domain;

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
        if (money % LotteryMachine.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매가능합니다.");
        }
    }
}
