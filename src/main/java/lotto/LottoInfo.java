package lotto;

public enum LottoInfo {
    PRICE(1000),
    FIRST_NUMBER(1),
    LAST_NUMBER(45),
    NUMBER_COUNT(6);

    private final int info;

    LottoInfo(int info) {
        this.info = info;
    }

    public int getInfo() {
        return this.info;
    }
}
