package lotto.domain;

import java.util.List;
import lotto.dto.LottoWinningNumbers;

public class LottoResultCalculator {

    public double calculateProfitRate(List<Lotto> lottos, LottoWinningNumbers lottoWinningNumbers, int purchaseAmount) {
        int totalPrize = lottos.stream()
                .mapToInt(lotto -> lotto.calculateRank(
                        lottoWinningNumbers.getWinningNumbers(),
                        lottoWinningNumbers.getBonusNumber()
                ).getPrize())
                .sum();

        return (double) totalPrize / purchaseAmount * 100;
    }
}
