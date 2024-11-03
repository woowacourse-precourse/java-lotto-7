package lotto.util;

import lotto.enums.lotto.LottoMessage;

public class LottoValidator {

    private static final int PRICE_UNIT = 1000;

    public static void validatePriceUnit(int price) {
        if (price % PRICE_UNIT != 0) {
            throw new IllegalArgumentException(LottoMessage.EXCEPTION_PRICE_UNIT.getMessage());
        }

        if (price <= 0) {
            throw new IllegalArgumentException(LottoMessage.EXCEPTION_PRICE_UNIT.getMessage());
        }
    }

    public static int validNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoMessage.EXCEPTION_NUMBER_VALID.getMessage());
        }
    }
}
