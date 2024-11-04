package lotto.domain;

public enum Rank {
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, "6개 일치");

    private final Integer matchCount;
    private final Integer prize;
    private final String message;
    private int count;

    Rank(Integer matchCount, Integer prize, String message) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.message = message;
        this.count = 0;
    }

    public static void resetCount() {
        for (Rank rank : Rank.values()) {
            rank.count = 0;
        }
    }

    public static Rank of(int matchCount, boolean checkBonus) {
        for (Rank rank : Rank.values()) {
            if (checkBonus) {
                SECOND.countPrize();
                return SECOND;
            }
            if (rank.matchCount.equals(matchCount)) {
                rank.countPrize();
                return rank;
            }
        }
        return null;
    }

    public void countPrize() {
        this.count++;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }

    public int getCount() {
        return count;
    }
}
