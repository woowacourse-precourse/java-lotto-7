package lotto.viewHandler.validator;

import lotto.viewHandler.Validator;
import lotto.viewHandler.exception.NotInteger;

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
