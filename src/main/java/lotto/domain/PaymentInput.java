package lotto.domain;

import lotto.common.CommonValidator;
import lotto.common.ErrorMessage;


public class PaymentInput {
    private static final int UNIT=1000;
    int payment;
    int lottoCounts;

    public int getLottoCounts() {
        return lottoCounts;
    }

    public int getPayment() {
        return payment;
    }


    public PaymentInput(String input){
        CommonValidator.validateNullAndBlank(input);
        this.payment=CommonValidator.validateInteger(input);
        validateUnit(payment);
        this.lottoCounts=payment/UNIT;
    }

    private void validateUnit(int payment) {
        if (payment%UNIT!=0 || payment==0){
            throw new IllegalArgumentException(ErrorMessage.NOT_UNIT_INPUT);
        }
    }


}
