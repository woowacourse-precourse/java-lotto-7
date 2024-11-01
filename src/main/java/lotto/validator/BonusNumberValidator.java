package lotto.validator;

import lotto.constant.ErrorConstants;

public class BonusNumberValidator implements Validator{

    private static final String SPACE = " ";
    @Override
    public void validate(String input){
        checkIfEmpty(input);
    }

    private void checkIfEmpty(String input){

        if(input.isEmpty() || input.equals(SPACE)){
            throw new IllegalArgumentException(ErrorConstants.EMPTY_VALUE_NOT_ALLOWED.getMessage());
        }
    }
}
