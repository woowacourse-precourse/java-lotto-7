package lotto.constant;

public enum PurchaseAmountValidatorConstant {
    MIN_PURCHASE_AMOUNT(0),
    MAX_PURCHASE_AMOUNT(100000),
    THOUSAND(1000);

    private final int value;

    PurchaseAmountValidatorConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
