package lotto.controller;

import lotto.domain.*;

public class LottoStatisticsController {

    public LottoResult calculateLottoPrizes(Lottos lottos, LottoWinningNumbers lottoWinningNumbers, long userPurchaseMoney) {
        LottoResult lottoResult = LottoResult.createLottoResult(userPurchaseMoney);
        calculateLottoPrize(lottos, lottoWinningNumbers, lottoResult);
        return lottoResult;
    }

    private void calculateLottoPrize(Lottos lottos, LottoWinningNumbers lottoWinningNumbers, LottoResult lottoResult) {
        for (Lotto lotto : lottos.getLottos()) {
            LottoPrize lottoPrize = lotto.calculatePrize(lottoWinningNumbers);
            lottoResult.addPrize(lottoPrize);
        }
    }
}
