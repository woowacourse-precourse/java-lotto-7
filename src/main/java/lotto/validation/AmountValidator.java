package lotto.validation;

import lotto.utils.ErrorMessages;

public class AmountValidator implements Validator<Integer> {
    private static final int LOTTO_PRICE = 1000;
    private static final AmountValidator INSTANCE = new AmountValidator();

    private AmountValidator() {
    }

    public static AmountValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public void validate(Integer amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_AMOUNT_UNIT);
        }
    }
}
