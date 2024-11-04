package lotto.model;

public enum Ranks {
    MISS(0, 0, "", 0),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - ", 0),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - ", 0),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - ", 0),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 0),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ", 0);

    private final int hits;
    private final int reward;
    private final String message;
    private int count;

    Ranks(int hits, int reward, String message, int count) {
        this.hits = hits;
        this.reward = reward;
        this.message = message;
        this.count = count;
    }

    public static void checkRanks(int hits, boolean isBonusHit) {
        clearHitCount();
        Ranks rankResult = MISS;

        for (Ranks rank : Ranks.values()) {
            if (rank.hasEqualHits(hits)) {
                rankResult = rank;
                break;
            }
        }
        if (rankResult == THIRD && isBonusHit) {
            rankResult = SECOND;
        }
        increaseHitCount(rankResult);
    }

    public static void clearHitCount() {
        for (Ranks rank : Ranks.values()) {
            rank.count = 0;
        }
    }

    private static void increaseHitCount(Ranks rank) {
        rank.count++;
    }

    private boolean hasEqualHits(int hits) {
        return this.hits == hits;
    }

    public int getReward() {
        return reward;
    }

    public String getMessage() {
        return message;
    }

    public int getCount() {
        return count;
    }
}