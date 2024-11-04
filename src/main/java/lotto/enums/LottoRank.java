package lotto.enums;

public enum LottoRank {
    FIFTH(LottoGameInformation.LOTTO_SIZE - 3, false, 5_000),
    FOURTH(LottoGameInformation.LOTTO_SIZE - 2, false, 50_000),
    THIRD(LottoGameInformation.LOTTO_SIZE - 1, false, 1_500_000),
    SECOND(LottoGameInformation.LOTTO_SIZE - 1, true, 30_000_000),
    FIRST(LottoGameInformation.LOTTO_SIZE, false, 2_000_000_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean secondBonus;
    private final int prize;

    LottoRank(int matchCount, boolean secondBonus, int prize) {
        this.matchCount = matchCount;
        this.secondBonus = secondBonus;
        this.prize = prize;
    }

    public static LottoRank getLottoRank(int matchCount, boolean secondBonus) {
        if (matchCount == FIRST.matchCount) {
            return FIRST;
        }
        if (matchCount == SECOND.matchCount && secondBonus) {
            return SECOND;
        }
        if (matchCount == THIRD.matchCount) {
            return THIRD;
        }
        if (matchCount == FOURTH.matchCount) {
            return FOURTH;
        }
        if (matchCount == FIFTH.matchCount) {
            return FIFTH;
        }
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
