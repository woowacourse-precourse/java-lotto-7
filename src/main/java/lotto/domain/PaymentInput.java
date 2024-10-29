package lotto.domain;

import lotto.common.CommonValidator;
import lotto.common.ErrorMessage;


public class PaymentInput {
    private static final int UNIT=1000;

    int payment;

    public PaymentInput(String input){
        CommonValidator.validateNullAndBlank(input);
        payment=CommonValidator.validateInteger(input);
        validateUnit(payment);
    }

    private void validateUnit(int payment) {
        if (payment%UNIT!=0 || payment==0){
            throw new IllegalArgumentException(ErrorMessage.NOT_UNIT_INPUT);
        }
    }


}
