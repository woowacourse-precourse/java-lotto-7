package lotto.model;

public enum Prize {
    FIFTH(3, 5000L),
    FOURTH(4, 50000L),
    THIRD(5, 1500000L),
    SECOND(5, 30000000L),
    FIRST(6, 2000000000L);

    private final int ranking;
    private final long prizeMoney;


    Prize(int ranking, long prizeMoney) {
        this.ranking = ranking;
        this.prizeMoney = prizeMoney;
    }

    public int getRanking() {
        return this.ranking;
    }

    public long getPrizeMoney() {
        return this.prizeMoney;
    }
}
