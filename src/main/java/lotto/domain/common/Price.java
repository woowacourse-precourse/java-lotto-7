package lotto.domain.common;

import java.util.Objects;

public class Price {

    private static final int UNIT = 1000;
    private static final int MIN_PRICE = 1000;
    private static final int MAX_PRICE = Integer.MAX_VALUE;
    private static final int EMPTY_CHANGE = 0;
    private static final String CANNOT_ZERO = "금액은 0일 수 없습니다.";
    private static final String REQUIRE_MULTIPLE_OF_THOUSAND = "금액은 1000 단위여야 합니다.";
    private static final String OUT_OF_RANGE = "금액은 " + MIN_PRICE + " ~ " + MAX_PRICE + "사이어야 합니다.";
    private final int price;

    public Price(int price) {
        validatePriceIsZero(price);
        validateOutOfRange(price);
        validateNoChangeRequired(price);
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Price price1)) {
            return false;
        }
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price);
    }

    private void validatePriceIsZero(int price) {
        if (price == 0) {
            throw new IllegalArgumentException(CANNOT_ZERO);
        }
    }

    private void validateOutOfRange(int price) {
        if (price < MIN_PRICE || price > MAX_PRICE) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }

    private void validateNoChangeRequired(int price) {
        if (price % UNIT != EMPTY_CHANGE) {
            throw new IllegalArgumentException(REQUIRE_MULTIPLE_OF_THOUSAND);
        }
    }

    public int divide(int price) {
        return this.price / price;
    }

    public int getPrice() {
        return price;
    }
}