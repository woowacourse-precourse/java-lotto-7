package lotto.validator;

import lotto.enums.ExceptionMessage;

import static lotto.enums.ExceptionMessage.*;

public abstract class Validator {
    abstract void validate(String input) throws IllegalArgumentException;

    public void validateInt(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        }catch (Exception e){
            throw new IllegalArgumentException(NOT_INT.getMessage());
        }
    }
}
