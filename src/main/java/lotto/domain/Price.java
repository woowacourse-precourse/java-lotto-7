package lotto.domain;

public class Price {
    private static final String INVALID_PRICE_RANGE_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.";
    private static final String INVALID_PRICE_UNIT_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 1000원 단위어야 합니다.";
    private static final int UNIT_PRICE = 1000;
    private final int value;

    public Price(final int value) {
        validatePrice(value);
        this.value = value;
    }

    private void validatePrice(final int value) {
        validatePriceRange(value);
        validatePriceUnit(value);
    }

    private void validatePriceRange(final int value) {
        if (islowerThanMinPrice(value)) {
            throw new IllegalArgumentException(INVALID_PRICE_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean islowerThanMinPrice(final int value) {
        return value <= UNIT_PRICE;
    }

    private void validatePriceUnit(final int value) {
        if (isNotUnitPrice(value)) {
            throw new IllegalArgumentException(INVALID_PRICE_UNIT_ERROR_MESSAGE);
        }
    }

    private boolean isNotUnitPrice(final int value) {
        return value % UNIT_PRICE != 0;
    }

    public int convertToTicket() {
        return value / UNIT_PRICE;
    }
}
