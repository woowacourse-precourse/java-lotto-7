package lotto.service;

import lotto.enums.ErrorMessage;

public class IntegerParserService {
    public int parse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER_PARSE_FAIL.getMessage());
        }
    }

}
