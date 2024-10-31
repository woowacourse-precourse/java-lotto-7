package lotto.model;

import lotto.util.Validator;

public class LottoStore {

    private static final int MAX_BUY_PRICE = 100_000;

    private static final int LOTTO_PRICE = 1000;

    public static LottoTicket makeLottoTicket(String purchaseMoney) {
        validateInput(purchaseMoney);
        return null;
    }

    private static void validateInput(String purchaseMoney) {
        Validator.isEmptyInput(purchaseMoney);
        Validator.isDigitString(purchaseMoney);
        int number = Validator.isInteger(purchaseMoney);
        Validator.isNumberWithinRange(number, LOTTO_PRICE, MAX_BUY_PRICE);
    }
}
