package lotto.domain;

import lotto.utils.ValidatorFactory;
import lotto.validation.Validator;

public class Purchase {
    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public Purchase(int amount) {
        Validator<Integer> amountValidator = ValidatorFactory.getAmountValidator();
        amountValidator.validate(amount);
        this.amount = amount;
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
