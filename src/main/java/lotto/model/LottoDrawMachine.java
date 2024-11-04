package lotto.model;

import java.util.List;
import lotto.Rank;

public class LottoDrawMachine {
    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;
    private LottoResult lottoResult;

    public LottoDrawMachine(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottoResult = new LottoResult();
    }

    public void compareLottoToWinning() {
        lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            List<Integer> result = lotto.compareNumbersToWinningNumbers(winningNumbers);
            boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);
            Rank rank = Rank.findRank(result.size(), hasBonusNumber);
            lottoResult.addResult(rank);
        }
    }

    public LottoResult prizeWinningResult() {
        return lottoResult;
    }

    public Double calculateEarningsRate() {
        long totalWinningPrice = lottoResult.calculateTotalEarnings();
        long purchaseAmount = lottos.size() * 1000L;
        return (double) totalWinningPrice / purchaseAmount * 100;
    }
}
