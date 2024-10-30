package lotto.controller;

import lotto.domain.LottoPurchase;
import lotto.factory.LottoPurchaseFactory;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottoPurchase lottoPurchase = inputAmount();

        int purchaseAmount = lottoPurchase.getPurchaseAmount();
        OutputView.printPurchaseAmount(purchaseAmount);
    }

    private LottoPurchase inputAmount() {
        return LottoPurchaseFactory.createLottoPurchase();
    }


}
