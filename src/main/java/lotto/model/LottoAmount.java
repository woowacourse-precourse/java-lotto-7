package lotto.model;

import lotto.Message.ErrorMessage;

public class LottoAmount {
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;

    public LottoAmount(String input) {
        int purchaseAmount = validateNumber(input);
        validateAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getAmount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    private int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_NUMBER.toString());
        }
    }

    private void validateAmount(int amount) {
        if ((amount % LOTTO_PRICE) != 0 || amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_THOUSAND_UNIT.toString());
        }
    }
}
