package lotto.model;

public record PurchasePrice(int value) {
    private static final int LOTTO_PRICE = 1000;

    public PurchasePrice {
        validate(value);
    }

    private void validate(final int value) {
        validateIsPositive(value);
        validateIsPurchaseUnit(value);
    }

    private void validateIsPositive(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIsPurchaseUnit(final int value) {
        if (value % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int calculateQuantity() {
        return LOTTO_PRICE / 1000;
    }
}
