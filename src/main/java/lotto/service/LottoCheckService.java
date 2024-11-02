package lotto.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Ranking;
import lotto.domain.WinningNumber;
import lotto.dto.LottoOutputDto;

public class LottoCheckService {

    public LottoOutputDto checkLottos(final String purchaseAmount, final WinningNumber winningNumber,
                                      final Lottos lottos) {
        LottoResult lottoResult = new LottoResult();
        Set<Integer> lottoChecker = new HashSet<>(winningNumber.getWinningNumber());

        for (Lotto lotto : lottos.getLottos()) {
            checkLotto(lottoChecker, lotto, winningNumber.getBonusNumber(), lottoResult);
        }
        double rateOfReturn = calculateRateOfReturn(Long.parseLong(purchaseAmount), lottoResult);

        return new LottoOutputDto(rateOfReturn, lottoResult);
    }

    private void checkLotto(Set<Integer> lottoChecker, Lotto lotto, int bonusNumber,
                            LottoResult lottoResult) {
        Ranking ranking = Ranking.getRanking(checkLottoNumber(lottoChecker, lotto),
                checkBonusNumber(bonusNumber, lotto));
        if (ranking != null) {
            lottoResult.addResult(ranking);
        }
    }

    private int checkLottoNumber(final Set<Integer> lottoChecker, final Lotto lotto) {
        int matchCount = 0;

        for (int number : lotto.getNumbers()) {
            if (lottoChecker.contains(number)) {
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
