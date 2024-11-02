package lotto.service;

import lotto.enums.ErrorCode;
import lotto.exception.FormatException;

public class StringParser {

    public int parseToInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new FormatException(ErrorCode.PARSING_INTEGER_ERROR);
        }
    }
}
