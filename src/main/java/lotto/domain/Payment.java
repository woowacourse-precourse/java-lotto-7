package lotto.domain;

import static lotto.message.ErrorMessage.AMOUNT_NOT_DIVISIBLE;
import static lotto.message.ErrorMessage.NON_POSITIVE_AMOUNT;

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

    public int getPayment() {
        return payment;
    }

    private void validate(int payment) {
        validatePositiveNumber(payment);
        validateDivisible(payment);
    }

    private void validatePositiveNumber(int payment) {
        if (payment < 0) {
            throw new IllegalArgumentException(NON_POSITIVE_AMOUNT.getMessage());
        }
    }

    private void validateDivisible(int payment) {
        if (payment % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(AMOUNT_NOT_DIVISIBLE.getMessage());
        }
    }

}
