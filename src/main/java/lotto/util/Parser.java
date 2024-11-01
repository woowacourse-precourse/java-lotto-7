package lotto.util;

import static lotto.constants.ExceptionMessage.INVALID_INPUT;

import lotto.validation.InputMoneyValidator;

public class Parser {
    public static int parseNumber(String value) {
        return Integer.parseInt(InputMoneyValidator.beforeParseValidate(value));
    }
}