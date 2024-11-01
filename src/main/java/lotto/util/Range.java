package lotto.util;

public enum Range {
    MIN(0),
    MAX(45);

    private final int num;

    Range(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
