package lotto.validator;

import lotto.constant.ErrorConstants;

public class Validator {

    public void validatePrice(String input){
        inputIsNumber(input);
    }

    private void inputIsNumber(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorConstants.INVALID_PRICE_FORMAT.getMessage());
        }
    }


}
