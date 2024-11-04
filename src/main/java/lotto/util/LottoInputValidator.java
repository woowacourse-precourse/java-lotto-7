package lotto.util;

import lotto.exception.LottoNumberException;
import lotto.exception.message.Error;

public class LottoInputValidator {

    public static String validateEmpty(String input) {
        if (input.isBlank()) {
            throw new LottoNumberException(Error.EMPTY_VALUE);
        }

        return input;
    }
}
