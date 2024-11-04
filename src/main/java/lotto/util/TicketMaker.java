package lotto.util;

import lotto.exception.PriceException;

public class TicketMaker {

    private static final int PRICE_UNIT = 1000;
    private static final int NOTHING = 0;

    public static int make(int price) {
        validateUnit(price);

        return price / PRICE_UNIT;
    }

    private static void validateUnit(int price) {
        if (price % PRICE_UNIT != NOTHING) {
            throw new PriceException(PRICE_UNIT);
        }
    }
}
