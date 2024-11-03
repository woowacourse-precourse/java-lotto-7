package lotto.util;

import lotto.enums.lotto.LottoMessage;

public class LottoValidator {

    public static int validNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoMessage.EXCEPTION_NUMBER_VALID.getMessage());
        }
    }
}
