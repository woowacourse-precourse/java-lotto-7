package lotto.domain;

import lotto.common.config.LottoRank;

public class MatchResult {
    private final int matchCount;
    private final boolean bonusMatch;
    private final LottoRank rank;

    public MatchResult(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.rank = LottoRank.getLottoRank(matchCount, bonusMatch);
    }

    public LottoRank getRank() {
        return rank;
    }
}
