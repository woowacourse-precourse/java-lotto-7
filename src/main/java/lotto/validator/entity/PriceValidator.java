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
            String message = ExceptionMessage.PRICE_NOT_VALID_FORMAT.getMessage();

            System.out.println(message);

            throw new IllegalArgumentException(message);
        }
    }

    private void isNull() {
        if (price == null) {
            printErrorMessageAndThrowError(ExceptionMessage.PRICE_IS_NULL.getMessage());
        }
    }

    private void isValidPrice() {
        int inputPrice = isValueInRange();
        isMultipleOfAThousand(inputPrice);
    }

    private int isValueInRange() {
        int price = 0;
        try {
            price = Integer.parseInt(this.price);
        } catch (Exception e) {
            printErrorMessageAndThrowError(ExceptionMessage.PRICE_OUT_OF_RANGE.getMessage());
        }

        return price;
    }

    private void isMultipleOfAThousand(int inputValue) {
        if (inputValue == 0 || inputValue % 1000 > 0) {
            printErrorMessageAndThrowError(ExceptionMessage.PRICE_NOT_MULTIPLE_OF_THOUSAND.getMessage());
        }
    }
}