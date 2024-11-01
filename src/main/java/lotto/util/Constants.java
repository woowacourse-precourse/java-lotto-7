package lotto.util;

public enum Constants {
    LOTTO_PRICE(1000),
    MAX_MONEY(10000000000000L), // 10조, Long.MAX_VALUE 보단 작게
    MIN_MONEY(1);


    private final long number;

    Constants(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }
}
