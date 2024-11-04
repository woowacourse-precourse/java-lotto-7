package lotto;

public enum Rank {
    FIFTH(3, 5000, false, "3개 일치"),
    FOURTH(4, 50000, false, "4개 일치"),
    THIRD(5, 1500000, false, "5개 일치"),
    SECOND(5, 30000000, true, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2000000000, false, "6개 일치"),
    NONE(0, 0, false, "X");

    private final int matchCount;
    private final int prize;
    private final boolean bonus;
    private final String message;

    Rank(int matchCount, int prize, boolean bonus, String message) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonus = bonus;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getBonus() {
        return bonus;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }

    // 로직 맞는지 확인해야함 .
    public static Rank calculateRank(int matchCount, boolean bonus) {
        if (matchCount == 5 && bonus) {
            return SECOND;
        }

        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() == matchCount) {
                return rank;
            }
        }

        return NONE;
    }
}
