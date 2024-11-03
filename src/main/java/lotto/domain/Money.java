package lotto.domain;

import lotto.ErrorCode;

public class Money {
    private final Integer amount;

    public Money(String amount) {
        validate(amount);
        this.amount = Integer.parseInt(amount);
    }

    public Integer getAmount() {
        return amount;
    }

    private void validate(String input) {
        validatePriceNumeric(input);
        validatePriceDivisible(input);
    }

    private void validatePriceNumeric(String price) {
        try {
            Integer.parseInt(price);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorCode.INPUT_POSITIVE_INTEGER.getErrorMessage());
        }
    }

    private void validatePriceDivisible(String input) {
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorCode.PRICE_DIVIDABLE_BY_UNIT.getErrorMessage());
        }
    }
}
