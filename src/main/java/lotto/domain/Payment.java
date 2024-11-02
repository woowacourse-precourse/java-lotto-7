package lotto.domain;

import lotto.global.contents.LottoDetail;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class Payment {

    private final int payment;

    private Payment(int payment, LottoDetail price) {
        Validator.validateDivisibleByPrice(payment, price);
        this.payment = payment;
    }

    public static Payment of(int payment, LottoDetail price) {
        return new Payment(payment, price);
    }

    public int calculateCount(LottoDetail price) {
        return payment / price.getValue();
    }

    public double divide(long profit) {
        return (double) profit / payment;
    }

    public int getPayment() {
        return payment;
    }

    private static class Validator {
        private static void validateDivisibleByPrice(int money, LottoDetail price) {
            if (isNotDivisibleByPrice(money, price)) {
                throw new LottoException(ErrorMessage.INVALID_PAYMENT_FORMAT);
            }
        }

        private static boolean isNotDivisibleByPrice(int money, LottoDetail price) {
            return money % price.getValue() != 0;
        }
    }
}
