package lotto.model;

import lotto.Message.ErrorMessage;

public class LottoAmount {
    private static final int LOTTO_PRICE = 1000;
    private static final String NUMBER_FORMAT = "^[0-9]+$";
    private final int amount;

    public LottoAmount(String input) {
        validateNumber(input);
        int amount = Integer.parseInt(input);
        validateAmount(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount / LOTTO_PRICE;
    }

    private void validateNumber(String input) {
        if (!input.matches(NUMBER_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.toString());
        }
    }

    private void validateAmount(int amount) {
        if ((amount % LOTTO_PRICE) != 0 || amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND_UNIT.toString());
        }
    }
}
