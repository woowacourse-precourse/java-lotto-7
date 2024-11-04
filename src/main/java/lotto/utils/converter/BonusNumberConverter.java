package lotto.utils.converter;

import lotto.utils.ErrorMessages;

public class BonusNumberConverter {

    private BonusNumberConverter() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static int convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NON_INTEGER_LOTTO_NUMBER);
        }
    }
}
