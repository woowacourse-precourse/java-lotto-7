package lotto.domain;

import lotto.global.contents.LottoDetail;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class Payment {

    private static final int MAX_PAYMENT = 100_000;
    private static final int ZERO = 0;

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

    private static class Validator {
        private static void validate(int payment, LottoDetail price) {
            validateZero(payment);
            validateDivisibleByPrice(payment, price);
            validateMaximum(payment);
        }

        private static void validateMaximum(int payment) {
            if (isOverMaximum(payment)) {
                throw new LottoException(ErrorMessage.INVALID_MAXIMUM_PAYMENT);
            }
        }

        private static boolean isOverMaximum(int payment) {
            return payment > MAX_PAYMENT;
        }

        private static void validateZero(int payment) {
            if (isZero(payment)) {
                throw new LottoException(ErrorMessage.INVALID_ZERO_PAYMENT);
            }
        }

        private static boolean isZero(int payment) {
            return payment == ZERO;
        }

        private static void validateDivisibleByPrice(int payment,
                                                     LottoDetail price) {
            if (isNotDivisibleByPrice(payment, price)) {
                throw new LottoException(ErrorMessage.INVALID_PAYMENT_FORMAT);
            }
        }

        private static boolean isNotDivisibleByPrice(int payment,
                                                     LottoDetail price) {
            return payment % price.getValue() != 0;
        }
    }
}
