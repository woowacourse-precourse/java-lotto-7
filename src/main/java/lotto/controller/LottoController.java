package lotto.controller;

import lotto.domain.PurchasePrice;
import lotto.domain.PurchasedLotto;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {

    private final InputService InputService;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(final InputService inputService, final OutputView outputView, final LottoService lottoService) {
        this.InputService = inputService;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void start() {
        PurchasePrice purchasePrice = InputService.readPurchasePrice();
        PurchasedLotto purchasedLotto = lottoService.issueLottoNumAsPurchaseQuantity(purchasePrice.getQuantity());
        outputView.printPurchaseAmount(purchasePrice.getQuantity());
        outputView.printPurchasedLottos(purchasedLotto.getPurchasedLottos());
    }

}
