package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.model.Lottos;
import lotto.view.PurchaseAmountInputView;
import lotto.view.PurchasedLottoOutputView;

public class LottoPurchaseController {
    private final Lottos lottos;
    private final LottoPurchase lottoPurchase;

    public LottoPurchaseController(Lottos lottos, LottoPurchase lottoPurchase) {
        this.lottos = lottos;
        this.lottoPurchase = lottoPurchase;
    }

    public void start() {
        purchaseLotto();
        generateLottos();
        printPurchasedLotto();
    }

    private long purchaseLotto() {
        PurchaseAmountInputView purchaseAmountInputView = new PurchaseAmountInputView();
        purchaseAmountInputView.printPurchaseAmountInputGuide();

        lottoPurchase.calculateLottoPurchaseCount(purchaseAmountInputView.getPurchaseAmount());
        return lottoPurchase.getLottoPurchaseCount();
    }

    private void generateLottos() {
        long lottoPurchaseCount = lottoPurchase.getLottoPurchaseCount();

        for (int lottoCount = 0; lottoCount < lottoPurchaseCount; lottoCount++) {
            Lotto lotto = lottos.createLotto();
            lottos.saveLotto(lotto);
        }
    }

    private void printPurchasedLotto() {
        PurchasedLottoOutputView purchasedLottoOutputView = new PurchasedLottoOutputView();

        long lottoPurchaseCount = lottoPurchase.getLottoPurchaseCount();

        purchasedLottoOutputView.printLottoPurchaseCount(lottoPurchaseCount);
        purchasedLottoOutputView.printPurchasedLottos(lottos.getLottoDtos());
    }
}
