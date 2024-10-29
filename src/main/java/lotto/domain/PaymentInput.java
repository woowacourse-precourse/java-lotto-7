package lotto.domain;

import lotto.common.CommonValidator;


public class PaymentInput {
    int payment;

    public PaymentInput(String input){
        CommonValidator.validateNullAndBlank(input);
        payment=CommonValidator.validateInteger(input);
    }


}
