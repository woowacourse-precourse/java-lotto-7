package lotto.enums;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - "),
    NONE(0, false, 0, "0개 일치 - ");

    public static final int BONUS_CONDITION = 5;
    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;
    private final String message;

    Rank(int matchCount, boolean matchBonus, int prize, String message) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
        this.message = message;
    }

    public static Rank determineRank(int matchCount, boolean matchBonus) {
        if (matchCount == BONUS_CONDITION && matchBonus)
            return SECOND;

        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public String generateResultMessage(int count) {
        return message + count + "개";
    }
}
