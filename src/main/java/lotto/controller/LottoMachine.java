package lotto.controller;

import lotto.model.LottoRanks;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.WinLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
    private final OutputView outputView;
    private final LottoInputHandler lottoInputHandler;

    public LottoMachine(InputView inputView, OutputView outputView) {
        this.outputView = outputView;
        this.lottoInputHandler = new LottoInputHandler(inputView);
    }

    public void lottery() {
        PurchaseAmount purchaseAmount = lottoInputHandler.initializePurchaseAmount();
        Lottos purchasedLottos = purchaseLottos(purchaseAmount);
        WinLotto winLotto = lottoInputHandler.initializeWinLotto();

        checkWinner(purchaseAmount, purchasedLottos, winLotto);
    }

    private void checkWinner(PurchaseAmount purchaseAmount, Lottos purchasedLottos, WinLotto winLotto) {
        LottoRanks lottoRanks = new LottoRanks(purchasedLottos, winLotto);

        outputView.printLottoResult(lottoRanks, purchaseAmount);
    }


    private Lottos purchaseLottos(PurchaseAmount purchaseAmount) {
        Lottos lottos = new Lottos(purchaseAmount);
        outputView.printPurchaseLottos(lottos);

        return lottos;
    }
}
