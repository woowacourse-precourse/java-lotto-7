package lotto.validator;

import lotto.enums.ExceptionMessage;

import static lotto.enums.Constants.MAX_LOTTO_NUM;
import static lotto.enums.Constants.MIN_LOTTO_NUM;
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
    public void validateRange(String input) {
        Integer lottoNum = Integer.parseInt(input);
        if (lottoNum < MIN_LOTTO_NUM.getValue() || lottoNum > MAX_LOTTO_NUM.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUM_RANGE.getMessage());
        }
    }
}
