package lotto.validation;

import lotto.exception.LottoException;

public class LottoValidator {
    protected static void isEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(LottoException.NULL_INPUT.getMessage());
        }
    }
}
