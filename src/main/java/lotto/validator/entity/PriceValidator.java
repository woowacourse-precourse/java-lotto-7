package lotto.validator.entity;

import lotto.enums.ExceptionMessage;
import lotto.validator.Validator;

// 구입 금액 검증 클래스
public class PriceValidator implements Validator {
    private final String price;

    public PriceValidator(String price) {
        this.price = price;
    }

    @Override
    public void validate() {
        isNull();
        isValidFormat();
        isValidPrice();
    }

    private void isValidFormat() {
        if (!price.matches("[0-9]+")) {
            throw new IllegalArgumentException(ExceptionMessage.PRICE_NOT_VALID_FORMAT.getMessage());
        }
    }

    private void isNull() {
        if (price == null) {
            throw new IllegalArgumentException(ExceptionMessage.PRICE_IS_NULL.getMessage());
        }
    }

    private void isValidPrice() {
        int inputPrice = isValueInRange();
        isMultipleOfAThousand(inputPrice);
    }

    private int isValueInRange() {
        try {
            return Integer.parseInt(price);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.PRICE_OUT_OF_RANGE.getMessage());
        }
    }

    private void isMultipleOfAThousand(int inputValue) {
        if (inputValue == 0 || inputValue % 1000 > 0) {
            throw new IllegalArgumentException(ExceptionMessage.PRICE_NOT_MULTIPLE_OF_THOUSAND.getMessage());
        }
    }
}