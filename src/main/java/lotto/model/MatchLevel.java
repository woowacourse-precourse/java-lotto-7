package lotto.model;

public enum MatchLevel {
    NO_MATCHES(0,0),
    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    FIVE_PLUS_BONUS(5, 30000000, true),
    SIX_MATCHES(6, 2000000000);

    private final int matchCount;
    private final int prize;
    private final boolean requiresBonus;

    MatchLevel(int matchCount, int prize) {
        this(matchCount, prize, false);
    }

    MatchLevel(int matchCount, int prize, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.requiresBonus = requiresBonus;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isWin() {
        return this != NO_MATCHES;
    }

    public String toString() {
        StringBuilder description = new StringBuilder();
        description.append(matchCount).append("개 일치");

        if(requiresBonus) {
            description.append(", 보너스 볼 일치");
        }

        description.append(" (")
            .append(String.format("%,d", prize))
            .append("원)");

        return description.toString();
    }

    public static MatchLevel getMatchLevel(int matchCount, boolean bonusMatched) {
        for (MatchLevel level : values()) {
            if (level.matchCount == matchCount && level.requiresBonus == bonusMatched) {
                return level;
            }
        }
        return NO_MATCHES;
    }

}
