package lotto.constant;

public enum LotteryConst {

    PRICE(1000),
    AMOUNT(6),
    MIN(1),
    MAX(45);

    private final int value;

    LotteryConst(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
