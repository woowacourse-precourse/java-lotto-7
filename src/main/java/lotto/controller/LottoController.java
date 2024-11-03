package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.PurchasePrice;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {

    private final InputService inputService;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(final InputService inputService, final OutputView outputView, final LottoService lottoService) {
        this.inputService = inputService;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void start() {
        PurchasePrice purchasePrice = inputService.readPurchasePrice();
        PurchasedLotto purchasedLotto = lottoService.issueLottoNumAsPurchaseQuantity(purchasePrice.getQuantity());

        printPurchaseAmountAndLotto(purchasePrice.getQuantity(), purchasedLotto);

        WinningLotto winningLotto = inputService.readWinningLotto();

        LottoResult lottoResult = lottoService.checkLottoResult(purchasedLotto.getPurchasedLottos(), winningLotto);
        double rate = lottoService.calcRate(purchasePrice.getPurchasePrice(), lottoResult);

        printResult(lottoResult, rate);
    }

    private void printPurchaseAmountAndLotto(final int quantity, final PurchasedLotto purchasedLotto) {
        outputView.printPurchaseAmount(quantity);
        outputView.printPurchasedLottos(purchasedLotto.getPurchasedLottos());
    }

    private void printResult(final LottoResult lottoResult, final double rate) {
        outputView.printLottoResults(lottoResult);
        outputView.printTotalRate(rate);
    }

}
