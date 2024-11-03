package lotto.model;

import java.util.List;

public class LottoResultCalculator {

    public LottoResult calculateLottoResult(WinningLotto winningLotto, List<Lotto> lottos) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            int matchCount = winningLotto.countMatchedLottoNumber(lotto);
            boolean isBonusMatch = winningLotto.isMatchBonusNumber(lotto);
            lottoResult.add(WinningStatus.getWinningStatus(matchCount, isBonusMatch));
        }
        return lottoResult;
    }
}
