package lotto.validator;

import lotto.Exception.NotANumberException;
import lotto.Exception.NullOrEmptyException;

public class NumberValidator implements Validator {
    private static final String NUMBER_PATTERN = "-?\\d+(\\.\\d+)?";

    @Override
    public void validate(String text) throws IllegalArgumentException {
        if (isNullOrEmpty(text)) {
            throw new NullOrEmptyException();
        }
        if (!isNumber(text)) {
            throw new NotANumberException();
        }
    }

    private boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private boolean isNumber(String text) {
        return text.matches(NUMBER_PATTERN);
    }
}
