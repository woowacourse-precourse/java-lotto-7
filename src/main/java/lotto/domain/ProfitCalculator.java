package lotto.domain;

import lotto.dto.MatchResult;
import lotto.enums.LottoRank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ProfitCalculator {

    public long calculateTotalWinningAmount(List<MatchResult> matchResults) {
        return matchResults.stream()
                .mapToLong(this::calculateWinningAmount)
                .sum();
    }

    public double calculateProfitRate(long totalWinningAmount, long purchaseAmount) {
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException("구입금액이 0원일 수 없습니다.");
        }

        BigDecimal profit = BigDecimal.valueOf(totalWinningAmount);
        BigDecimal profitRate = profit.divide(BigDecimal.valueOf(purchaseAmount), 10, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP);
        return profitRate.doubleValue();
    }

    private long calculateWinningAmount(MatchResult matchResult) {
        LottoRank rank = LottoRank.of(matchResult.matchCount(), matchResult.containBonusNumber());
        return rank.getMoney();
    }
}
