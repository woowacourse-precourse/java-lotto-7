package lotto.validator;

import lotto.enums.Exceptions;

public class AmountValidator {

    public void validateNull(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException(Exceptions.NOT_BLANK.getMessage());
        }
    }

}
