package lotto.validator;

import lotto.common.ErrorMessage;

public class PaymentValidator {
    public static long validateRawPayment(String input){
        validateNullAndBlank(input);
        validateLongType(input);

        return Long.parseLong(input);
    }

    private static void validateLongType(String input) {
        try{
            Long.parseLong(input);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE);
        }
    }

    private static void validateNullAndBlank(String input) {
        if (input==null || input.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.BLANK_OR_NULL_INPUT);
        }
    }
}
