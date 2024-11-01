package lotto.validator;

import lotto.enums.Constants;
import lotto.enums.ExceptionMessage;

import static lotto.enums.Constants.*;
import static lotto.enums.ExceptionMessage.INVALID_MONEY_UNIT;
import static lotto.enums.ExceptionMessage.ZERO_EXCEPTION;

public class MoneyValidator extends Validator {

    @Override
    public void validate(String input) throws IllegalArgumentException {
        validateInt(input);
        validateUnit(input);
        validateZero(input);
    }

    public void validateUnit(String input) {
        if (Integer.parseInt(input)% MONEY_UNIT.getValue() !=0){
            throw new IllegalArgumentException(INVALID_MONEY_UNIT.getMessage());
        }
    }

    public void validateZero(String input) {
        if (Integer.parseInt(input)==0){
            throw new IllegalArgumentException(ZERO_EXCEPTION.getMessage());
        }
    }

}
