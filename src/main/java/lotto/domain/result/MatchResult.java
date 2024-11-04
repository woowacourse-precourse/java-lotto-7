package lotto.domain.result;

public class MatchResult {
    private final int matchedNumberCount;
    private final boolean isBonusNumberMatched;
    private final int rank;

    private MatchResult(int matchedNumberCount, boolean isBonusNumberMatched) {
        this.matchedNumberCount = matchedNumberCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
        this.rank = RankDecider.getRank(matchedNumberCount, isBonusNumberMatched);

    }

    public static MatchResult create(int matchedNumberCount, boolean isBonusNumberMatched) {
        return new MatchResult(matchedNumberCount, isBonusNumberMatched);
    }

    public int getRank(){
        return rank;
    }
    public int getMatchedNumberCount(){
        return matchedNumberCount;
    }
    public boolean isBonusNumberMatched(){
        return isBonusNumberMatched;
    }

}
