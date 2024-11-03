package lotto.core;

public class LottoResult {
    public final int matchCount;
    public final boolean isMatch;

    public LottoResult(int matchCount, boolean isMatch) {
        this.matchCount = matchCount;
        this.isMatch = isMatch;
    }
    public int getMatchCount() {
        return matchCount;
    }
    public boolean isMatch() {
        return isMatch;
    }
}
