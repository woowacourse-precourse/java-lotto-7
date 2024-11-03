package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.dto.LottoWinningNumbers;

public class LottoResultCalculator {

    public BigDecimal calculateProfitRate(List<Lotto> lottos, LottoWinningNumbers lottoWinningNumbers,
                                          int purchaseAmount) {
        long totalPrize = calculateTotalPrize(lottos, lottoWinningNumbers);

        BigDecimal profitRate = new BigDecimal(totalPrize)
                .divide(new BigDecimal(purchaseAmount), 10, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(100));

        return profitRate.setScale(1, RoundingMode.HALF_UP);
    }

    private long calculateTotalPrize(List<Lotto> lottos, LottoWinningNumbers lottoWinningNumbers) {
        return lottos.stream()
                .mapToLong(lotto -> lotto.calculateRank(
                        lottoWinningNumbers.getWinningNumbers(),
                        lottoWinningNumbers.getBonusNumber()
                ).getPrize())
                .sum();
    }
}
