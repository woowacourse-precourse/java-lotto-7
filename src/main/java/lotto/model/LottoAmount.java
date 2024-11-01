package lotto.model;

import lotto.Message.ErrorMessage;

public class LottoAmount {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public LottoAmount(String input) {
        int amount = validateNumber(input);
        validateAmount(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount / LOTTO_PRICE;
    }

    private int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.toString());
        }
    }

    private void validateAmount(int amount) {
        if ((amount % LOTTO_PRICE) != 0 || amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND_UNIT.toString());
        }
    }
}
