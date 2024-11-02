package lotto.domain;

import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class Payment {

    private static final int PRICE = 1000;

    private final int payment;

    private Payment(int payment) {
        Validator.validateDivisibleByPrice(payment);
        this.payment = payment;
    }

    public static Payment of(int payment) {
        return new Payment(payment);
    }

    public int calculateCount() {
        return payment / PRICE;
    }

    public double divide(long profit) {
        return (double) profit / payment;
    }

    public int getPayment() {
        return payment;
    }

    private static class Validator {
        private static void validateDivisibleByPrice(int money) {
            if (isNotDivisibleByPrice(money)) {
                throw new LottoException(ErrorMessage.INVALID_PAYMENT_FORMAT);
            }
        }

        private static boolean isNotDivisibleByPrice(int money) {
            return money % PRICE != 0;
        }
    }
}
