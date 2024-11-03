package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoEvaluator {

    private final WinningNumbers winningNumbers;

    public LottoEvaluator(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public LottoResult evaluate(List<Lotto> purchasedLotteries) {
        LottoResult lottoResult = new LottoResult();

        purchasedLotteries.stream().map(this::determineRank).forEach(lottoResult::incrementRankCount);

        return lottoResult;
    }

    public BigDecimal calculateYield(LottoResult results, int purchaseAmount) {
        BigDecimal totalWinnings = new BigDecimal(results.calculateTotalWinnings());

        return totalWinnings.multiply(BigDecimal.valueOf(100))
                .divide(BigDecimal.valueOf(purchaseAmount), 1, RoundingMode.HALF_UP).stripTrailingZeros();

    }

    private LottoRank determineRank(Lotto lotto) {
        int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::isWinningNumber).count();

        boolean hasBonus = winningNumbers.isBonusNumber(lotto);

        return LottoRank.getRank(matchCount, hasBonus);
    }
}
