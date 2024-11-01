package lotto.domain;

import lotto.dto.MatchCondition;
import lotto.enums.LottoRank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ProfitCalculator {

    public long calculateTotalWinningAmount(List<MatchCondition> matchConditions) {
        return matchConditions.stream()
                .mapToLong(this::calculateWinningAmount)
                .sum();
    }

    public double calculateProfitRate(long totalWinningAmount, long purchaseAmount) {
        BigDecimal profit = BigDecimal.valueOf(totalWinningAmount - purchaseAmount);
        BigDecimal profitRate = profit.divide(BigDecimal.valueOf(purchaseAmount), 1, RoundingMode.HALF_UP);
        return profitRate.doubleValue();
    }

    private long calculateWinningAmount(MatchCondition matchCondition) {
        LottoRank rank = LottoRank.of(matchCondition.matchCount(), matchCondition.containBonusNumber());
        return rank.getMoney();
    }
}
