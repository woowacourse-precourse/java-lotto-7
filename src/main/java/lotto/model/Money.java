package lotto.model;

import lotto.util.InputValidator;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;
    private final InputValidator validator;

    public Money(String input, InputValidator validator) {
        if (validator == null) {
            throw new IllegalStateException("입력 검증기가 초기화되지 않았습니다.");
        }
        this.validator = validator;
        validator.validatePurchaseAmount(input);
        this.amount = Integer.parseInt(input);
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
