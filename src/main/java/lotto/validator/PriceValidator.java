package lotto.validator;

import static lotto.constant.ErrorConstants.NEGATIVE_PRICE_NOT_ALLOWED;
import static lotto.constant.ErrorConstants.NULL_NOT_ALLOWED;
import static lotto.constant.ErrorConstants.EXCEEDED_MAX_RANGE;
import static lotto.constant.ErrorConstants.INVALID_PRICE_FORMAT;
import static lotto.constant.UtilConstants.MINIMUM_PRICE;
import static lotto.constant.UtilConstants.MAX;

public class PriceValidator implements Validator {
    private final static int ZERO = 0;
    private int price;

    @Override
    public void validate(String input) {
        checkInputIsNotNull(input);
        checkInputIsNumber(input);
        parseInputToNumber(input);
        checkPriceNotExceedsMax();
        checkInputIsNotNegative();
        checkInputIsDivisableByThousand();
    }

    private void checkInputIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PRICE_FORMAT.getMessage());
        }
    }

    private void checkInputIsNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_NOT_ALLOWED.getMessage());
        }
    }

    private void parseInputToNumber(String input) {
        price = Integer.parseInt(input);
    }

    private void checkPriceNotExceedsMax() {
        if (price > MAX) {
            throw new IllegalArgumentException(EXCEEDED_MAX_RANGE.getMessage());
        }
    }

    private void checkInputIsNotNegative() {
        if (price <= ZERO) {
            throw new IllegalArgumentException(NEGATIVE_PRICE_NOT_ALLOWED.getMessage());
        }
    }

    private void checkInputIsDivisableByThousand() {
        if (price % MINIMUM_PRICE != ZERO) {
            throw new IllegalArgumentException(INVALID_PRICE_FORMAT.getMessage());
        }
    }

}
