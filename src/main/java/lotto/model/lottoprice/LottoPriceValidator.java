package lotto.model.lottoprice;

import lotto.model.ErrorMessage;

public class LottoPriceValidator {

    private static final int MIN_PRICE = 0;
    private static final int LOTTO_PRICE = 1000;

    public String validate(String price) {
        if (validateNullInput(price)) {
            return ErrorMessage.EMPTY_INPUT.getMessage();
        }

        if (validateNegative(price)) {
            return ErrorMessage.NEGATIVE_INPUT.getMessage();
        }

        if (validatePriceMultiple(price)) {
            return ErrorMessage.MULTIPLE_INPUT.getMessage();
        }
        return price;
    }

    private Boolean validateNullInput(String price) {
        try {
            if (price == null || price.isBlank()) {
                throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private boolean validateNegative(String price) {
        try {
            int numericPrice = Integer.parseInt(price);
            if (numericPrice < MIN_PRICE) {
                throw new IllegalArgumentException(ErrorMessage.NEGATIVE_INPUT.getMessage());
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private boolean validatePriceMultiple(String price) {
        try {
            int numericPrice = Integer.parseInt(price);
            if (numericPrice % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException(ErrorMessage.MULTIPLE_INPUT.getMessage());
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }
}
