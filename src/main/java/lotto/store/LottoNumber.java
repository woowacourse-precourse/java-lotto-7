package lotto.store;

public enum LottoNumber {
    START(1),
    LAST(45),
    COUNT(6);

    private final int value;

    LottoNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isNotEqualCount(int count) {
        return count != COUNT.value;
    }

    public static boolean isNotRange(int value) {
        return value < LottoNumber.START.value || value > LottoNumber.LAST.value;
    }
}
