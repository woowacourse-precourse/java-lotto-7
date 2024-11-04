package lotto.validator;

import static lotto.constant.ExceptionMessage.INVALID_PRICE_CHAR;
import static lotto.constant.ExceptionMessage.INVALID_PRICE_MULTIPLE;
import static lotto.constant.ExceptionMessage.INVALID_PRICE_ZERO;

public class PurchasePriceValidator {

    private final static int LOTTO_PRICE = 1000;
    private final static char MIN_NUM_CHAR = '0';
    private final static char MAX_NUM_CHAR = '9';
    private final static String INVALID_PRICE_PATTERN = "0+";

    public void validate(String purchasePrice) {
        validateChar(purchasePrice);
        validateMultiple(purchasePrice);
        validateZero(purchasePrice);
    }

    private void validateChar(String purchasePrice) {
        for (char c : purchasePrice.toCharArray()) {
            if (c < MIN_NUM_CHAR || c > MAX_NUM_CHAR) {
                throw new IllegalArgumentException(INVALID_PRICE_CHAR.getMessage());
            }
        }
    }

    private void validateMultiple(String purchasePrice) {
        if (Integer.parseInt(purchasePrice) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PRICE_MULTIPLE.getMessage());
        }
    }

    private void validateZero(String purchasePrice) {
        if (purchasePrice.matches(INVALID_PRICE_PATTERN)) {
            throw new IllegalArgumentException(INVALID_PRICE_ZERO.getMessage());
        }
    }

}
