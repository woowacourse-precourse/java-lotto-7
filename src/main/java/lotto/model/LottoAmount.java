package lotto.model;

import lotto.Message.ErrorMessage;

public class LottoAmount {
    private static final int THOUSAND_UNIT = 1000;
    private final int amount;

    public LottoAmount(String input) {
        validateNumber(input);
        int amount = Integer.parseInt(input);
        validateAmount(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount / THOUSAND_UNIT;
    }

    private void validateNumber(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.toString());
        }
    }

    private void validateAmount(int amount) {
        if ((amount % THOUSAND_UNIT) != 0 || amount < 1000) {
            throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND_UNIT.toString());
        }
    }
}
