package lotto.model;

import static lotto.common.constants.ExceptionMessages.INVALID_INPUT;

public class LottoPurchase {
    private final Integer amount;
    private final Integer count;
    private static final Integer LOTTO_PRICE = 1000;

    public LottoPurchase(Integer amount) {
        validate(amount);
        this.amount = amount;
        this.count = amount / LOTTO_PRICE;
    }

    public void validate(Integer amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getCount() {
        return count;
    }
}
