package lotto.viewHandler.validator.validatorImpl;

import lotto.viewHandler.exception.NotInteger;
import lotto.viewHandler.validator.Validator;

import static lotto.viewHandler.exception.MyExceptionConstant.NOT_INTEGER;

public class ParseInt implements Validator<Integer, String> {
    @Override
    public Integer validate(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotInteger(NOT_INTEGER);
        }
    }
}
