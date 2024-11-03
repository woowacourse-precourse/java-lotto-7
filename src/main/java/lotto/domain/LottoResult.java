package lotto.domain;

public class LottoResult {

    private final int matchCount;
    private final boolean isBonusMatched;

    public LottoResult(int matchCount, boolean isBonusMatched) {
        this.matchCount = matchCount;
        this.isBonusMatched = isBonusMatched;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }
}
