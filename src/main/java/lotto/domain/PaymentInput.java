package lotto.domain;

import lotto.common.ErrorMessage;


public class PaymentInput {
    private static final long UNIT=1000;
    private final long payment;
    private final long lottoCounts;

    public PaymentInput(long payment){
        validatePositiveNumber(payment);
        validateUnit(payment);

        this.payment=payment;
        this.lottoCounts= this.payment /UNIT;
    }

    public long getLottoCounts() {
        return lottoCounts;
    }

    public long getPayment() {
        return payment;
    }

    private static void validatePositiveNumber(long input) {
        if (input<0){
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_INPUT);
        }
    }

    private void validateUnit(long payment) {
        if (payment%UNIT!=0 || payment==0){
            throw new IllegalArgumentException(ErrorMessage.NOT_UNIT_INPUT);
        }
    }
}
