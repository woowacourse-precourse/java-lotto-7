package lotto;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    MISS(0, false, 0);

    private final int matchNumberCount;
    private final boolean matchBonusNumber;
    private final int prize;

    Rank(int matchNumberCount, boolean matchBonusNumber, int prize) {
        this.matchNumberCount = matchNumberCount;
        this.matchBonusNumber = matchBonusNumber;
        this.prize = prize;
    }

    public static Rank decideRank(int matchNumberCount, boolean matchBonusNumber) {
        if (matchNumberCount == 6) {
            return FIRST;
        }
        if (matchNumberCount == 5 && matchBonusNumber) {
            return SECOND;
        }
        if (matchNumberCount == 5) {
            return THIRD;
        }
        if (matchNumberCount == 4) {
            return FOURTH;
        }
        if (matchNumberCount == 3) {
            return FIFTH;
        }
        return MISS;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public boolean isMatchBonusNumber() {
        return matchBonusNumber;
    }

    public int getPrize() {
        return prize;
    }
}
