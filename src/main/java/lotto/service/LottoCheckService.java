package lotto.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;
import lotto.domain.Ranking;
import lotto.dto.LottoOutputDto;

public class LottoCheckService {

    public LottoOutputDto checkLottos(final String purchaseAmount, final LottoWinningNumbers lottoWinningNumbers,
                                      final Lottos lottos) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : lottos.getLottos()) {
            checkLotto(lottoWinningNumbers, lotto, lottoResult);
        }
        double rateOfReturn = calculateRateOfReturn(Long.parseLong(purchaseAmount), lottoResult);

        return new LottoOutputDto(rateOfReturn, lottoResult);
    }

    private void checkLotto(final LottoWinningNumbers lottoWinningNumbers, final Lotto lotto,
                            final LottoResult lottoResult) {
        Set<Integer> winningNumberChecker = new HashSet<>(lottoWinningNumbers.getWinningNumber());
        Ranking ranking = Ranking.getRanking(checkWinningNumber(winningNumberChecker, lotto),
                checkBonusNumber(lottoWinningNumbers.getBonusNumber(), lotto));

        if (ranking != null) {
            lottoResult.addResult(ranking);
        }
    }

    private int checkWinningNumber(final Set<Integer> winningNumberChecker, final Lotto lotto) {
        int matchCount = 0;

        for (int number : lotto.getNumbers()) {
            if (winningNumberChecker.contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    private boolean checkBonusNumber(final int bonusNumber, final Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private double calculateRateOfReturn(final long purchaseAmount, final LottoResult lottoResult) {
        Map<Ranking, Integer> results = lottoResult.getLottoResult();

        long sumOfRevenue = 0;
        for (Ranking ranking : results.keySet()) {
            sumOfRevenue += (long) ranking.getWinningPrize() * results.get(ranking);
        }

        return Math.round((double) sumOfRevenue / purchaseAmount * 1000) / 10.0;
    }
}
