package lotto.util;

import lotto.error.LottoError;

public abstract class LottoParser {

    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoError.INVALID_NUMBER.getMessage());
        }
    }
}
