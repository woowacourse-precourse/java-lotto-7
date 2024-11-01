package lotto.util;

public enum ConstantNumbers {
    LOTTO_PRICE(1000),
    MAX_MONEY(10000000000000L), // 10조, Long.MAX_VALUE 보단 작게
    MIN_MONEY(1);


    private final long number;

    ConstantNumbers(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }
}
