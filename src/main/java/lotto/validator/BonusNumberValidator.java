package lotto.validator;

import lotto.common.ErrorMessage;

public class BonusNumberValidator {

    public static int validateBonusNumber(String input){
        validateNullAndBlank(input);

        int parsedNumber= validateOnlyNumber(input);

        return parsedNumber;
    }

    private static int validateOnlyNumber(String input){
        try{
            return Integer.parseInt(input);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_TYPE);
        }

    }

    private static void validateNullAndBlank(String input) {
            if (input==null || input.isBlank()){
                throw new IllegalArgumentException(ErrorMessage.BLANK_OR_NULL_INPUT);
            }
    }
}
