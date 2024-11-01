package lotto.validator;

import lotto.constant.ErrorConstants;

public class Validator {
    private final static int ZERO = 0;
    public void validatePrice(String input){
        checkInputIsNotNull(input);
        checkInputIsNumber(input);

        checkInputIsNotNegative(input);
    }

    private void checkInputIsNumber(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorConstants.INVALID_PRICE_FORMAT.getMessage());
        }
    }

    private void checkInputIsNotNull(String input){
        if(input == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_NOT_ALLOWED.getMessage());
        }
    }

    private void checkInputIsNotNegative(String input){
        if(Integer.parseInt(input) <= ZERO){
            throw new IllegalArgumentException(ErrorConstants.NEGATIVE_PRICE_NOT_ALLOWED.getMessage());
        }
    }



}
