package lotto.validation;

import lotto.exception.LottoException;

public class LottoValidator {
    // null 값에 대한 오류
    protected static void isEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(LottoException.NULL_INPUT.getMessage());
        }
    }
}
