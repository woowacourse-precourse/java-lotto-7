package lotto.domain;

public class MatchResult {
    private final int matchedNumberCount;
    private final boolean isBonusNumberMatched;

    private MatchResult(int matchedNumberCount, boolean isBonusNumberMatched) {
        this.matchedNumberCount = matchedNumberCount;
        this.isBonusNumberMatched = isBonusNumberMatched;

    }

    public static MatchResult create(int matchedNumberCount, boolean isBonusNumberMatched) {
        return new MatchResult(matchedNumberCount, isBonusNumberMatched);
    }

    public boolean isBonusNumberMatched() {
        return isBonusNumberMatched;
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }
}
