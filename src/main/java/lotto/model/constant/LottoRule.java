package lotto.model.constant;

public enum LottoRule {
    PRICE(1000),
    MAX_PURCHASE_COUNT(100),

    NUMBER_COUNT(6),

    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final int constant;

    LottoRule(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }
}
