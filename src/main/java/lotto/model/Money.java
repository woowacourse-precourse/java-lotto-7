package lotto.model;

import lotto.constant.LottoConstants;
import lotto.util.InputValidator;

public class Money {
    private final int amount;

    public Money(String input, InputValidator validator) {
        validate(input, validator);
        this.amount = Integer.parseInt(input);
    }

    private void validate(String input, InputValidator validator) {
        if (validator == null) {
            throw new IllegalStateException("입력 검증기가 초기화되지 않았습니다.");
        }
        validator.validatePurchaseAmount(input);
    }

    public int getLottoCount() {
        return amount / LottoConstants.LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
