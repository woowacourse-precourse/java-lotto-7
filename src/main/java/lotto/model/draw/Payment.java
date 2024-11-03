package lotto.model.draw;

import static lotto.constant.ErrorMessage.INVALID_PAYMENT_POSITIVE_INTEGER;
import static lotto.constant.ErrorMessage.INVALID_PAYMENT_UNIT;
import static lotto.constant.LottoConstant.PRICE;

public class Payment {
    private final int payment;

    public Payment(final String payment) {
        validatePositiveInteger(payment);
        this.payment = Integer.parseInt(payment);
        validateDivideByePrice();
    }

    private void validatePositiveInteger(final String payment) {
        if (!payment.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_PAYMENT_POSITIVE_INTEGER.getFormatMessage());
        }
    }

    private void validateDivideByePrice() {
        if (payment % PRICE != 0 || payment == 0) {
            throw new IllegalArgumentException(INVALID_PAYMENT_UNIT.getFormatMessage());
        }
    }

    public int getPayment() {
        return payment;
    }
}
