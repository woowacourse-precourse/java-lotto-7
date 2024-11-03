package lotto.domain;

public enum LottoPrize {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoPrize valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == FIRST.getMatchCount()) {
            return FIRST;
        } else if (matchCount == SECOND.getMatchCount() && matchBonus) {
            return SECOND;
        } else if (matchCount == THIRD.getMatchCount()) {
            return THIRD;
        } else if (matchCount == FOURTH.getMatchCount()) {
            return FOURTH;
        } else if (matchCount == FIFTH.getMatchCount()) {
            return FIFTH;
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
