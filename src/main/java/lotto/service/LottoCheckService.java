package lotto.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Ranking;
import lotto.dto.LottoInputDto;
import lotto.dto.LottoOutputDto;

public class LottoCheckService {

    public LottoOutputDto checkLottos(final LottoInputDto lottoInputDto, final Lottos lottos) {
        LottoResult lottoResult = new LottoResult();
        Set<Integer> lottoChecker = new HashSet<>(lottoInputDto.winningNumber());

        for (Lotto lotto : lottos.getLottos()) {
            checkLotto(lottoChecker, lotto, lottoInputDto, lottoResult);
        }
        double rateOfReturn = calculateRateOfReturn(lottoInputDto.purchaseAmount(), lottoResult);

        return new LottoOutputDto(rateOfReturn, lottoResult);
    }

    private void checkLotto(Set<Integer> lottoChecker, Lotto lotto, LottoInputDto lottoInputDto,
                            LottoResult lottoResult) {
        Ranking ranking = Ranking.getRanking(checkLottoNumber(lottoChecker, lotto),
                checkBonusNumber(lottoInputDto.bonusNumber(), lotto));
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

        return Math.round((double) sumOfRevenue / purchaseAmount * 100) / 100.0;
    }
}
