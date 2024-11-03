package lotto.model;

public enum Prize {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int ranking;
    private final long prizeMoney;


    Prize(int ranking, long prizeMoney) {
        this.ranking = ranking;
        this.prizeMoney = prizeMoney;
    }

    public int getRanking(){
        return this.ranking;
    }

    public long getPrizeMoney(){
        return this.prizeMoney;
    }
}
