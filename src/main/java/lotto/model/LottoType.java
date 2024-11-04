package lotto.model;

public enum LottoType {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    COUNT(6);

    private final int number;

    LottoType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
