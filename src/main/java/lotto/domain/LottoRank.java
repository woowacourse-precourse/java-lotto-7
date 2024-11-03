package lotto.domain;

public enum LottoRank {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchNumberCount;
    private final int prizeAmount;

    LottoRank(int matchNumberCount, int prizeAmount) {
        this.matchNumberCount = matchNumberCount;
        this.prizeAmount = prizeAmount;
    }

    public static LottoRank findRank(int matchNumberCount, boolean isMatchBonusNumber) {
        if (matchNumberCount == FIRST.matchNumberCount) {
            return FIRST;
        }
        if (matchNumberCount == SECOND.matchNumberCount && isMatchBonusNumber) {
            return SECOND;
        }
        if (matchNumberCount == THIRD.matchNumberCount && !isMatchBonusNumber) {
            return THIRD;
        }
        if (matchNumberCount == FOURTH.matchNumberCount) {
            return FOURTH;
        }
        if (matchNumberCount == FIFTH.matchNumberCount) {
            return FIFTH;
        }
        return NONE;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public String getFormattedPrizeAmount() {
        return String.format("%,d", prizeAmount);
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
