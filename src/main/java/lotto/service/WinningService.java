package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;
import lotto.dto.WinningResultDto;

public class WinningService {

    public WinningResultDto calculateWinningResult(Lottos lottos, WinningLotto winningLotto) {
        Map<Prize, Integer> rankCounts = calculateRankCounts(lottos, winningLotto);
        BigDecimal totalPrize = calculateTotalPrize(rankCounts);
        BigDecimal profitRate = calculateProfitRate(totalPrize, lottos.getLottoCount());

        return new WinningResultDto(rankCounts, profitRate);
    }

    private Map<Prize, Integer> calculateRankCounts(Lottos lottos, WinningLotto winningLotto) {
        return lottos.countMatchesWith(winningLotto);
    }

    private BigDecimal calculateTotalPrize(Map<Prize, Integer> rankCounts) {
        return rankCounts.entrySet().stream()
                .map(entry -> calculatePrizeForRank(entry.getKey(), entry.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculatePrizeForRank(Prize prize, int count) {
        return BigDecimal.valueOf(prize.getPrize()).multiply(BigDecimal.valueOf(count));
    }

    private BigDecimal calculateProfitRate(BigDecimal totalPrize, int purchaseAmount) {
        return totalPrize.divide(BigDecimal.valueOf(purchaseAmount), 2, RoundingMode.HALF_UP)
                .divide(BigDecimal.valueOf(10), 2, RoundingMode.HALF_UP)
                .stripTrailingZeros();
    }

}
