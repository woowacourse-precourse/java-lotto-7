package lotto.domain.lotto;

import lotto.domain.Rank;

public class LottoResult {
    private final int matchCount;
    private final boolean hasBonusNumber;

    public LottoResult(int matchCount, boolean hasBonusNumber) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public Rank determinRank() {
        return Rank.of(matchCount, hasBonusNumber);
    }
}
