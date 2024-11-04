package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.model.Lottos;
import lotto.view.ErrorOutputView;
import lotto.view.PurchaseAmountInputView;
import lotto.view.PurchasedLottoOutputView;

public class LottoPurchaseController {
    private final Lottos lottos;
    private final LottoPurchase lottoPurchase;
    private final PurchaseAmountInputView purchaseAmountInputView;

    public LottoPurchaseController(Lottos lottos, LottoPurchase lottoPurchase,
                                   PurchaseAmountInputView purchaseAmountInputView) {
        this.lottos = lottos;
        this.lottoPurchase = lottoPurchase;
        this.purchaseAmountInputView = purchaseAmountInputView;
    }

    public void start() {
        purchaseLotto();
        generateLottos();
        printPurchasedLotto();
    }

    private void purchaseLotto() {
        purchaseAmountInputView.printPurchaseAmountInputGuide();

        setLottoPurchaseFromInput();
    }

    private void setLottoPurchaseFromInput() {

        try {
            lottoPurchase.calculateLottoPurchaseCount(purchaseAmountInputView.getPurchaseAmount());
        } catch (IllegalArgumentException e) {

            ErrorOutputView.printErrorMessage(e);

            setLottoPurchaseFromInput();
        }
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
