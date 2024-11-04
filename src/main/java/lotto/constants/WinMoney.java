package lotto.constants;

public enum WinMoney {
    // 상금
    FIRST_MONEY(2_000_000_000L),
    SECOND_MONEY(30_000_000L),
    THIRD_MONEY(1_500_000L),
    FOURTH_MONEY(50_000L),
    FIFTH_MONEY(5_000L),

    ;
    private final long value;

    WinMoney(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
