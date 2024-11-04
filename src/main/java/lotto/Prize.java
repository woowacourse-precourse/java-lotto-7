package lotto;

public enum Prize {
    FIRST_PLACE(2_000_000_000L),
    SECOND_PLACE(30_000_000L),
    THIRD_PLACE(1_500_000L),
    FOURTH_PLACE(50_000L),
    FIFTH_PLACE(5_000L),
    NOTHING(0L);

    private final long prizeMoney;

    Prize(Long prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public long calculateTotalPrizeMoney(long count) {
        if (count < 0) {
            throw new IllegalArgumentException("[ERROR] 당첨 횟수는 음수가 될 수 없습니다.");
        }
        if (count > 1000000000) {
            throw new IllegalArgumentException("[ERROR] 당첨 횟수는 10억회를 초과할 수 없습니다.");
        }
        return prizeMoney * count;
    }
}
