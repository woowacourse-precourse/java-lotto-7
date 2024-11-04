package lotto.controller;

import lotto.model.LottoStore;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoStore store;

    public LottoController() {
        this.store = new LottoStore();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String purchaseAmount = inputView.getLottoPurchaseAmount();
        Lottos lottos = store.purchaseLottos(purchaseAmount);
        outputView.printLottos(lottos);
    }
}
