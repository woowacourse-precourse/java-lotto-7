package lotto.controller;

import lotto.model.LottoGenerator;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = new LottoGenerator();
    }

    public void run() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        Lottos lottos = issueLottos(purchaseAmount);
    }

    private PurchaseAmount inputPurchaseAmount() {
        outputView.printPurchaseAmountMessage();
        int purchaseAmount = inputView.inputPurchaseAmount();
        return PurchaseAmount.from(purchaseAmount);
    }

    private Lottos issueLottos(PurchaseAmount purchaseAmount) {
        int quantity = purchaseAmount.calculateQuantity();
        outputView.printQuantity(quantity);
        Lottos lottos = lottoGenerator.issue(quantity);
        outputView.printLottos(lottos);
        return lottos;
    }
}
