package lotto.model.enums;

public enum WinningType {
    NOTHING(0L, 0), THREE(5000L, 3), FOUR(50000L, 4), FIVE(1500000L, 5), FIVE_BONUS(30000000L, 5), SIX(2000000000L, 6);

    private Long prize;
    private Integer matchCount;

    WinningType(Long prize, Integer matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public static WinningType getWinningType(Integer matchCount, boolean matchBonus) {
        if (matchCount == 3) {
            return THREE;
        }
        if (matchCount == 4) {
            return FOUR;
        }
        if (matchCount == 5 && !matchBonus) {
            return FIVE;
        }
        if (matchCount == 5 && matchBonus) {
            return FIVE_BONUS;
        }
        if (matchCount == 6) {
            return SIX;
        }
        return NOTHING;
    }

    public Long getPrize() {
        return prize;
    }

    public Integer getMatchCount() {
        return matchCount;
    }
}
