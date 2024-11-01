package lotto.view;

import static lotto.model.rank.RankCondition.sortedValuesExceptNone;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.model.money.Money;
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

        EnumMap<RankCondition, String> stringValueEnumMap = RankCondition.stringMessageEnumMap();

        for (RankCondition rank : sortedValuesExceptNone()) {
            String matchedConditionCount = stringValueEnumMap.get(rank);
            Money prizeAmount = Money.findByRank(rank);
            String prizeCount = resultRankTable.getStringPrizeCount(rank);

            String message = String.format("%s %s - %s", matchedConditionCount, prizeAmount.toString(), prizeCount);
            messages.add(message);
        }

        return new StatisticView(messages, recoveryRatio.toString());
    }

    public List<String> getMatchingResults() {
        return matchingResults;
    }

    public String getRecoveryRatio() {
        return recoveryRatio;
    }
}
