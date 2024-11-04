package lotto.view;

import static lotto.model.rank.RankCondition.valuesExceptNone;

import java.util.ArrayList;
import java.util.List;
import lotto.model.rank.DrawResultRankTable;
import lotto.model.rank.RankCondition;
import lotto.model.statistic.RecoveryRatio;

public class StatisticView {

    private final List<String> matchingResults;
    private final String recoveryRatio;

    private StatisticView(final List<String> matchingResults, final String recoveryRatio) {
        this.matchingResults = matchingResults;
        this.recoveryRatio = recoveryRatio;
    }

    public static StatisticView from(final DrawResultRankTable resultRankTable, final RecoveryRatio recoveryRatio) {
        List<String> messages = new ArrayList<>();

        for (RankCondition rankCondition : valuesExceptNone()) {
            String rankConditionMessage = rankCondition.toStringMessage();
            String prizeCount = resultRankTable.toStringMessageOf(rankCondition);

            String message = generateMessageFrom(rankConditionMessage, prizeCount);
            messages.add(message);
        }

        return new StatisticView(messages, recoveryRatio.toString());
    }

    private static String generateMessageFrom(final String rankCondition, final String prizeCount) {
        return String.format("%s - %s", rankCondition, prizeCount);
    }

    public List<String> getMatchingResults() {
        return matchingResults;
    }

    public String getRecoveryRatio() {
        return recoveryRatio;
    }
}
