package lotto;

public enum Rank {
    NONE(0, 0, 0, "당첨되지 않음"),
    FIFTH(3, 0, 5_000, "3개 일치"),
    FOURTH(4, 0, 50_000, "4개 일치"),
    THIRD(5, 0, 1_500_000, "5개 일치"),
    SECOND(5, 1, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 0, 2_000_000_000, "6개 일치");
    
    private final int matchCount;
    private final int bonusCount;
    private final int prizeMoney;
    private final String description;
    
    Rank(int matchCount, int bonusCount, int prizeMoney, String description) {
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }
    
    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5) {
            if (matchBonus) {
                return SECOND;
            }
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }
    
    public int getPrizeMoney() {
        return prizeMoney;
    }
    
    public String getDescription() {
        return description;
    }
}
