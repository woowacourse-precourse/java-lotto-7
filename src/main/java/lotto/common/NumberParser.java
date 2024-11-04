package lotto.common;

import static lotto.common.ExceptionMessage.NO_NUMBER_FORMAT;

public class NumberParser {

    public static int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NO_NUMBER_FORMAT);
        }
    }
}
