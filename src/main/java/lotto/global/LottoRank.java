package lotto.global;

import static lotto.global.error.LottoErrorMessages.INVALID_MATCH_COUNT;
import static lotto.utils.Validator.BONUS_MATCH_THRESHOLD;

public enum LottoRank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;
    private final boolean bonus;

    LottoRank(int matchCount, int prize) {
        this(matchCount, prize, false);
    }

    LottoRank(int matchCount, int prize, boolean bonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonus = bonus;
    }

    public static LottoRank findByMatchCount(int i) {
        if (i == BONUS_MATCH_THRESHOLD) {
            throw new IllegalStateException(INVALID_MATCH_COUNT.getMessage() + i);
        }

        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMatchCount() == i) {
                return rank;
            }
        }

        throw new IllegalStateException(INVALID_MATCH_COUNT.getMessage() + i);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        return matchCount + "개 일치" +
                (bonus ? ", 보너스 볼 일치" : "") +
                " (" + String.format("%,d", prize) + "원)";
    }
}
