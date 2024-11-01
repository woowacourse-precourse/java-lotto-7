package lotto.validator;

import lotto.constant.ErrorConstants;

public class BonusNumberValidator implements Validator{

    private static final String SPACE = " ";
    @Override
    public void validate(String input){
        checkIfNull(input);
        checkIfEmpty(input);
        checkIfIsNumber(input);
    }

    private void checkIfNull(String input){
        if(input == null){
            throw new IllegalArgumentException(ErrorConstants.EMPTY_VALUE_NOT_ALLOWED.getMessage());
        }
    }
    private void checkIfEmpty(String input){

        if(input.isEmpty() || input.equals(SPACE)){
            throw new IllegalArgumentException(ErrorConstants.EMPTY_VALUE_NOT_ALLOWED.getMessage());
        }
    }

    private void checkIfIsNumber(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorConstants.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }


}
