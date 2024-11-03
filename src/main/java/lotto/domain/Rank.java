package lotto.domain;

public enum Rank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    NOTHING(0, false, 0);

    private final int matchWinning;
    private final boolean matchBonus;
    private final int rankMoney;

    Rank(int matchWinning, boolean matchBonus, int rankMoney) {
        this.matchWinning = matchWinning;
        this.matchBonus = matchBonus;
        this.rankMoney = rankMoney;
    }

    public int getRankWinning() {
        return matchWinning;
    }

    public boolean getRankBonus() {
        return matchBonus;
    }

    public int getRankMoney() {
        return rankMoney;
    }

}
