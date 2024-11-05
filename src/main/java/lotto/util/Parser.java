package lotto.util;

import lotto.validation.InputMoneyValidator;

public class Parser {
    public static int parseNumber(String value) {
        return Integer.parseInt(InputMoneyValidator.beforeParseValidate(value));
    }
}