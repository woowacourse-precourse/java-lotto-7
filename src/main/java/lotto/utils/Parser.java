package lotto.utils;

import static lotto.exception.ErrorMessage.MONEY_NOT_NUMBER;

import lotto.exception.LottoException;

public class Parser {
    public static int parsePrice(final String input) {
        int purchaseAmount;

        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoException(MONEY_NOT_NUMBER);
        }

        return purchaseAmount;
    }
}
