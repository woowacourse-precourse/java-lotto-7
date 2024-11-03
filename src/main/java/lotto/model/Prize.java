package lotto.model;

public enum Prize {
    THREE_MATCH(3, false, 5000),
    FOUR_MATCH(4, false, 50000),
    FIVE_MATCH(5, false, 1500000),
    FIVE_AND_BONUS_MATCH(5, true, 300000000),
    SIX_MATCH(6, false, 2000000000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeMoney;

    Prize(int matchCount, boolean matchBonus, int prizeMoney) {
        this.matchBonus = matchBonus;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Prize valueOf(int matchCount, boolean matchBonus){
        for (Prize prize: Prize.values()){
            if(prize.matchCount == matchCount && prize.matchBonus==matchBonus){
                return prize;
            }
        }
        return null;
    }
}
