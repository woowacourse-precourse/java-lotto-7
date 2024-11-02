package lotto.constant;

public enum LottoConstant {
    PRICE(1000),
    MAX_PURCHASE_AMOUNT(1000),
    MIN_PURCHASE_AMOUNT(1),
    MAX_NUMBER(45),
    MIN_NUMBER(1);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }
}
