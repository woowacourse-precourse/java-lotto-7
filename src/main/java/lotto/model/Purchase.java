package lotto.model;

public class Purchase {
    private final int price;

    public Purchase(int price) {
        validatePrice(price);
        this.price = price;
    }

    public int getQuantity() {
        return price / 1000;
    }

    private void validatePrice(int value) {
        validatePositive(value);
        validatePurchaseUnit(value);
    }

    private void validatePositive(final int value) {
        if (isNotPositive(value)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotPositive(final int value) {
        return value <= 0;
    }

    private void validatePurchaseUnit(final int value) {
        if (isNotMultipleOf1000(value)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotMultipleOf1000(final int value) {
        return value % 1000 != 0;
    }
}
