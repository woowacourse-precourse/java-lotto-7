package lotto.domain.calculator;

import java.math.BigDecimal;
import java.util.Map;
import lotto.domain.model.RankInfo;
import lotto.domain.factory.RankInfoFactory;

public class WinningAmountCalculator {
    private final Map<RankInfo, Integer> winningResults;
    private BigDecimal winningAmount;

    public WinningAmountCalculator(Map<RankInfo, Integer> winningResults) {
        this.winningResults = winningResults;
        calculateWinningAmount();
    }

    private void calculateWinningAmount() {
        this.winningAmount = RankInfoFactory.getAllRanks().stream().map((rankInfo) -> {
            int matchCount = winningResults.get(rankInfo);
            return calculatePrizeAmount(rankInfo.getPrizeAmount(), matchCount);
        }).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal calculatePrizeAmount(int prizeAmount, int count) {
        return BigDecimal.valueOf(prizeAmount).multiply(BigDecimal.valueOf(count));
    }

    public BigDecimal getWinningAmount() {
        return this.winningAmount;
    }
}
