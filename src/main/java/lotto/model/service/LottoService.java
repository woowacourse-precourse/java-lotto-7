package lotto.model.service;

import lotto.model.domain.LottoPrizes;
import lotto.model.domain.LottoWinning;
import lotto.model.domain.Lottos;
import lotto.model.domain.ProfitRatio;
import lotto.model.domain.PurchaseAmount;

public class LottoService {

    public Lottos createLottos(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.getLottoCount();
        return new Lottos(count);
    }

    public LottoPrizes drawWinners(Lottos lottos, LottoWinning lottoWinning) {
        return lottoWinning.getLottoPrizes(lottos);
    }

    public ProfitRatio getProfitRatio(PurchaseAmount purchaseAmount, LottoPrizes winners) {
        return winners.getProfitRatio(purchaseAmount.get());
    }


}
