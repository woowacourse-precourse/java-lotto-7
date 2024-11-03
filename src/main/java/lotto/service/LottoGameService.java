package lotto.service;

import lotto.model.LottoPurchase;

public class LottoGameService {

    public LottoPurchase createLottoPurchase(int purchaseAmount) {
        return new LottoPurchase(purchaseAmount);
    }
}
