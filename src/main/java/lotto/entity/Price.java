package lotto.entity;

import lotto.validator.Validator;
import lotto.validator.entity.PriceValidator;

// 구입가격 엔티티 클래스
public class Price {
    private final int value;
    private Validator validator;

    public Price(String inputValue) {
        initializeValidator(inputValue);
        validate();

        this.value = parsePrice(inputValue);
    }

    public int getValue() {
        return value;
    }

    private void validate() {
        validator.validate();
    }

    private void initializeValidator(String inputValue) {
        this.validator = new PriceValidator(inputValue);
    }

    private int parsePrice(String inputValue) {
        return Integer.parseInt(inputValue);
    }
}
