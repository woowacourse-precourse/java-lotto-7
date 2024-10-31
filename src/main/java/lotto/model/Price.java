package lotto.model;

public class Price {
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
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.");
        }
    }

    private boolean islowerThanMinPrice(final int value) {
        return value <= 1000;
    }

    private void validatePriceUnit(final int value) {
        if (isNotUnitPrice(value)) { // TODO: 조건문의 부정..? 어떻게 고치는 게 좋을까..
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위어야 합니다.");
        }
    }

    private boolean isNotUnitPrice(final int value) {
        return value % 1000 != 0;
    }

    public int convertToTicket() {
        return value / 1000;
    }
}
