package lotto.domain;

import lotto.global.contents.LottoDetail;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class Payment {

    private final int payment;

    private Payment(int payment, LottoDetail price) {
        Validator.validate(payment, price);
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
        private static void validate(int payment, LottoDetail price) {
            validateZero(payment);
            validateDivisibleByPrice(payment, price);
        }

        private static void validateZero(int payment) {
            if (isZero(payment)) {
                throw new LottoException(ErrorMessage.INVALID_ZERO_PAYMENT);
            }
        }

        private static boolean isZero(int payment) {
            return payment == 0;
        }

        private static void validateDivisibleByPrice(int payment, LottoDetail price) {
            if (isNotDivisibleByPrice(payment, price)) {
                throw new LottoException(ErrorMessage.INVALID_PAYMENT_FORMAT);
            }
        }

        private static boolean isNotDivisibleByPrice(int payment, LottoDetail price) {
            return payment % price.getValue() != 0;
        }
    }
}
