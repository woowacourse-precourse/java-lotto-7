package lotto.util;

import lotto.enums.ErrorMessage;

public class Util {
    public static int checkValidInteger(String number) {
        int num;
        try {
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS.getMessage());
        }
        return num;
    }
}
