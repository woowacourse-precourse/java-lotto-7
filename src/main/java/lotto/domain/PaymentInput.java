package lotto.domain;

import lotto.common.CommonValidator;


public class PaymentInput {
    int payment;

    public PaymentInput(String input){
        payment=CommonValidator.validateInteger(input);
    }


}
