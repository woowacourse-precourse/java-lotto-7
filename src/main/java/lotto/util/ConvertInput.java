package lotto.util;

import lotto.exception.ErrorMessage;
import lotto.exception.InputException;

public class ConvertInput {
    public static int makeMoneyToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw InputException.from(ErrorMessage.MONEY_HAS_CHARACTER);
        }
    }
}
