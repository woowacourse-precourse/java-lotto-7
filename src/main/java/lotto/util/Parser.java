package lotto.util;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class Parser {

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoException(ErrorMessage.TOO_BIG_INPUT.getMessage());
        }
    }
}
