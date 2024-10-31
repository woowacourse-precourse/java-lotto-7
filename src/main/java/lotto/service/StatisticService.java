package lotto.service;

import lotto.model.money.Money;
import lotto.model.rank.DrawResultRankTable;
import lotto.model.statistic.RecoveryRatio;

public class StatisticService {

    public RecoveryRatio returnOfInvestment(final DrawResultRankTable drawResultRankTable, final Money investment) {
        Money totalPrizeAmount = drawResultRankTable.totalPrizeAmount();
        return RecoveryRatio.of(
                totalPrizeAmount.toBigDecimal(),
                investment.toBigDecimal()
        );
    }
}
