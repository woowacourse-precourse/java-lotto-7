package lotto.validator;

import lotto.constant.Constant;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class Validator {
    public static final String NUMERIC_PATTERN = "-?\\d+";

    public static void validateBlank(String input, ErrorMessage errorMessage) {
        if (input == null || input.isBlank()) {
            throw new LottoException(errorMessage.getMessage());
        }
    }

    public static void validateNumeric(String input, ErrorMessage errorMessage) {
        if (!input.matches(NUMERIC_PATTERN)) {
            throw new LottoException(errorMessage.getMessage());
        }
    }

    public static void validateNumberRange(Integer number, ErrorMessage errorMessage) {
        if (number < Constant.MIN_LOTTO_NUMBER || number > Constant.MAX_LOTTO_NUMBER) {
            throw new LottoException(errorMessage.getMessage());
        }
    }
}
