package lotto.domain;

public enum Prize {
    NONE(0, 0, "미당첨"),
    FIFTH(3, 5000, "3개 일치"),
    FOURTH(4, 50000, "4개 일치"),
    THIRD(5, 1500000, "5개 일치"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2000000000, "6개 일치");

    private final int matchCount;
    private final int prizeMoney;
    private final String description;

    Prize(int matchCount, int prizeMoney, String description) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }
}
