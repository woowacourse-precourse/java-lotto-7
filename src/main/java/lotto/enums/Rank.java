package lotto.enums;

public enum Rank {
    FIRST_PLACE(6, 0, "6개 일치 (2,000,000,000원)", 2000000000),
    SECOND_PLACE(5, 1, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    THIRD_PLACE(5, 2, "5개 일치 (1,500,000원)", 1500000),
    FOURTH_PLACE(4, 3, "4개 일치 (50,000원)", 50000),
    FIFTH_PLACE(3, 4, "3개 일치 (5,000원)", 5000);

    private final int matchCount;
    private final int index;
    private final String message;
    private final long prizeMoney;

    Rank(int matchCount, int index, String message, long prizeMoney) {
        this.matchCount = matchCount;
        this.index = index;
        this.message = message;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getIndex() {
        return index;
    }

    public String getMessage(int count) {
        return message + " - " + count + "개";
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
