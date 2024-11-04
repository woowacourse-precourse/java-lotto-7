package lotto.validator;

import static lotto.validator.ValidatorUtils.PRICE_ERROR_MESSAGE;

public class PriceValidator implements Validator<Integer> {

    @Override
    public void validate(Integer price) {
        validatePositive(price);
        validateThousandUnit(price);
    }

    private void validatePositive(Integer price) {
        if (price <= 0) {
            throw new IllegalArgumentException(PRICE_ERROR_MESSAGE);
        }
    }

    private void validateThousandUnit(Integer price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PRICE_ERROR_MESSAGE);
        }
    }
}
