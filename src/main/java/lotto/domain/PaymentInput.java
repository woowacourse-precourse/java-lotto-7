package lotto.domain;

import lotto.common.ErrorMessage;
import lotto.common.RegexPattern;


public class PaymentInput {
    private static final long UNIT=1000;
    private final long payment;
    private final int lottoCounts;

    public PaymentInput(String input){
        validateNullAndBlank(input);
        this.payment=validatePositiveNumber(input);
        validateUnit(payment);
        this.lottoCounts= (int) (payment/UNIT);
    }

    public int getLottoCounts() {
        return lottoCounts;
    }

    public long getPayment() {
        return payment;
    }

    private static Long validatePositiveNumber(String input) {
        if (!RegexPattern.INTEGER_INPUT.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_INPUT);
        }
        return Long.parseLong(input);
    }

    private void validateUnit(long payment) {
        if (payment%UNIT!=0 || payment==0){
            throw new IllegalArgumentException(ErrorMessage.NOT_UNIT_INPUT);
        }
    }

    private static void validateNullAndBlank(String input) {
        if (input==null || input.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.BLANK_OR_NULL_INPUT);
        }
    }


}
