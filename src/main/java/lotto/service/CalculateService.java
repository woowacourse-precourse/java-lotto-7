package lotto.service;

import java.util.List;
import java.util.Map.Entry;
import lotto.model.money.Money;
import lotto.model.rank.DrawResultRankTable;
import lotto.model.rank.RankCondition;

public class CalculateService {

    public Money totalPriceFrom(DrawResultRankTable resultRankTable) {
        List<Money> monies = resultRankTable.initiateReadOnlyStream()
                .filter(this::hasReward)
                .map(this::toMoney)
                .toList();
        return Money.addAll(monies);
    }

    private boolean hasReward(final Entry<RankCondition, Integer> entry) {
        Integer rankCount = entry.getValue();
        return rankCount > 0;
    }

    private Money toMoney(final Entry<RankCondition, Integer> entry) {
        RankCondition rank = entry.getKey();
        Money prizePrice = Money.findByRank(rank);
        int prizeCount = entry.getValue();
        return prizePrice.multiply(prizeCount);
    }
}
