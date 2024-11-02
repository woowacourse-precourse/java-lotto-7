package lotto.model;

public record PurchasePrice(int value) {
    private static final int LOTTO_PRICE = 1000;

    public static PurchasePrice from(final int value) {
        validate(value);
        return new PurchasePrice(value);
    }

    private static void validate(final int value) {
        validateIsPositive(value);
        validateIsPurchaseUnit(value);
    }

    private static void validateIsPositive(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIsPurchaseUnit(final int value) {
        if (value % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int calculateQuantity() {
        return LOTTO_PRICE / 1000;
    }
}
