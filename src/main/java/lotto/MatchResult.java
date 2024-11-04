package lotto;

import java.util.List;

// TicketPrizeMatcher에 대한 당첨 결과를 담는 클래스
public class MatchResult {
    private final List<MatchCondition> matchedConditions;
    private final Double profitRatio;

    public MatchResult(
            List<MatchCondition> matchedConditions,
            Double profitRatio
    ) {
        this.matchedConditions = matchedConditions;
        this.profitRatio = profitRatio;
    }

    public List<MatchCondition> getMatchedConditions() {
        return matchedConditions;
    }
    public Double getProfitRatio() {
        return profitRatio;
    }
}
