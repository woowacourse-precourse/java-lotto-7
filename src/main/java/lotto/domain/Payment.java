package lotto.domain;

import lotto.util.Constants;

public class Payment {

    private final int payment;

    private Payment(int payment) {
        validate(payment);
        this.payment = payment;
    }

    public static Payment from(int payment) {
        return new Payment(payment);
    }

    public int getLottoAmount() {
        return payment / Constants.LOTTO_PRICE;
    }

    private void validate(int payment) {
        validatePositiveNumber(payment);
        validateDivisible(payment);
    }

    private void validatePositiveNumber(int payment) {
        if (payment < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivisible(int payment) {
        if (payment % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

}
