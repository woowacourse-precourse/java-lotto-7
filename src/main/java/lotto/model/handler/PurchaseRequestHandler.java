package lotto.model.handler;

import lotto.validator.InputValidator;

public class PurchaseRequestHandler {

    private static final int LOTTO_UNIT_PRICE = 1_000;

    public int getPurchaseAmount(String amount) {
        InputValidator.validateAmount(amount);
        int parsedAmount = Integer.parseInt(amount);

        return calculateLottoCount(parsedAmount);
    }

    private int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_UNIT_PRICE;
    }

}
