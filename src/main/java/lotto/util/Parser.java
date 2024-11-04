package lotto.util;

import lotto.exception.LottoNumberException;
import lotto.exception.message.Error;

public class Parser {

    private static final String DELIMITER = ",";

    public static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoNumberException(Error.NOT_NUMERIC);
        }
    }

    public static String[] splitWithDelimiter(String input) {
        return input.split(DELIMITER);
    }
}
