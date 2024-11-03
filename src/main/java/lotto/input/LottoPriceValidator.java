package lotto.input;

public class LottoPriceValidator {
    private static final int MIN_PRICE = 0;
    private static final String EMPTY_INPUT_ERROR = "[ERROR] 아무것도 입력되지 않았습니다.";
    private static final String NEGATIVE_INPUT_ERROR = "[ERROR] 구입 금액은 양수여야 합니다.";
    private static final String MULTIPLE_INPUT_ERROR = "[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.";
    private static final int LOTTO_PRICE = 1000;

    public String validate(String price) {
        if (validateNullInput(price)) {
            return EMPTY_INPUT_ERROR;
        }

        if (validateNegative(price)) {
            return NEGATIVE_INPUT_ERROR;
        }

        if (validatePriceMultiple(price)) {
            return MULTIPLE_INPUT_ERROR;
        }
        return price;
    }

    private Boolean validateNullInput(String price) {
        try {
            if (price == null || price.isBlank()) {
                throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
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
                throw new IllegalArgumentException(NEGATIVE_INPUT_ERROR);
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
                throw new IllegalArgumentException(MULTIPLE_INPUT_ERROR);
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }
}
