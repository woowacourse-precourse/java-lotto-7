package lotto.controller;

import lotto.domain.*;

public class LottoStatisticsController {

    public LottoResult calculateLottoPrizes(Lottos lottos, LottoWinningNumbers lottoWinningNumbers, long userPurchaseMoney) {

        LottoResult lottoResult = LottoResult.createLottoResult(userPurchaseMoney);
        for (Lotto lotto : lottos.getLottos()) {
            LottoPrize lottoPrize = lotto.calculatePrize(lottoWinningNumbers);
            lottoResult.addPrize(lottoPrize);
        }

        return lottoResult;
    }
}
