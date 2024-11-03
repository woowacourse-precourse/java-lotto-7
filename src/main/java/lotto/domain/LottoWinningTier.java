package lotto.domain;

import java.util.Arrays;

public enum LottoWinningTier {
    NONE(0, 0),
    MATCH_THREE(3, 5000),
    MATCH_FOUR(4, 50000),
    MATCH_FIVE(5, 1500000),
    MATCH_FIVE_WITH_BONUS(5, 30000000),
    MATCH_SIX(6, 2000000000);
    private final int matchCount;
    private final int prize;

    LottoWinningTier(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoWinningTier getMatchCountTier (int matchCount, boolean isBonusNumber) {
        if (matchCount == 5 && isBonusNumber) {
            return MATCH_FIVE_WITH_BONUS;
        }
        return Arrays.stream(LottoWinningTier.values())
                .filter(lottoWinningTier -> lottoWinningTier.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }
    public int getPrize() {
        return prize;
    }
}
