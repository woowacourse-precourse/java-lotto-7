package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.model.Lottos;
import lotto.view.PurchasedLottoOutputView;

public class LottoPurchaseController {
    private final Lottos lottos;
    private final LottoPurchase lottoPurchase;

    public LottoPurchaseController(Lottos lottos, LottoPurchase lottoPurchase) {
        this.lottos = lottos;
        this.lottoPurchase = lottoPurchase;
    }

    public void start(long purchaseAmount) {
        long lottoPurchaseCount = purchaseLotto(purchaseAmount);
        generateLottos(lottoPurchaseCount);
        printPurchasedLotto(lottoPurchaseCount);
    }

    private long purchaseLotto(long purchaseAmount) {
        lottoPurchase.calculateLottoPurchaseCount(purchaseAmount);
        return lottoPurchase.getLottoPurchaseCount();
    }

    private void generateLottos(long lottoPurchaseCount) {
        for (int lottoCount = 0; lottoCount < lottoPurchaseCount; lottoCount++) {
            Lotto lotto = lottos.createLotto();
            lottos.saveLotto(lotto);
        }
    }

    private void printPurchasedLotto(long lottoPurchaseCount) {
        PurchasedLottoOutputView purchasedLottoOutputView = new PurchasedLottoOutputView();
        purchasedLottoOutputView.printLottoPurchaseCount(lottoPurchaseCount);
        purchasedLottoOutputView.printPurchasedLottos(lottos.getLottoDtos());
    }
}
