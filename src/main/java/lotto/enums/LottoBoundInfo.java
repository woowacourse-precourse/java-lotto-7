package lotto.enums;

public enum LottoBoundInfo {
    MINIMUM_NUMBER(1),
    MAXIMUM_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    PRICE_PER_LOTTO(1000),
    LOTTO_PURCHASE_MONEY_MAXIMUM(1_000_000_000);

    private final int info;

    LottoBoundInfo(int infoNumber) {
        this.info = infoNumber;
    }

    public int getInfo() {
        return info;
    }

}
