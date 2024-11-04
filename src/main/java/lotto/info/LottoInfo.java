package lotto.info;

public enum LottoInfo {
    PRICE(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    COUNT(6);

    private final int number;

    LottoInfo(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
