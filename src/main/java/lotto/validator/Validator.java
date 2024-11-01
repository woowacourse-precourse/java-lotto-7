package lotto.validator;

import lotto.constant.ErrorConstants;

public class Validator {
    private final static int ZERO = 0;
    private final static int MINIMUM_PRICE_UNIT = 1000;
    private int price;
    public void validatePrice(String input){
        checkInputIsNotNull(input);
        checkInputIsNumber(input);

        parseInputToNumber(input);

        checkInputIsNotNegative();
        checkInputIsDivisableByThousand();
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

    private void parseInputToNumber(String input){
        price = Integer.parseInt(input);
    }

    private void checkInputIsNotNegative(){
        if(price <= ZERO){
            throw new IllegalArgumentException(ErrorConstants.NEGATIVE_PRICE_NOT_ALLOWED.getMessage());
        }
    }

    private void checkInputIsDivisableByThousand(){
        if(price % MINIMUM_PRICE_UNIT != ZERO){
            throw new IllegalArgumentException(ErrorConstants.INVALID_PRICE_FORMAT.getMessage());
        }
    }



}
