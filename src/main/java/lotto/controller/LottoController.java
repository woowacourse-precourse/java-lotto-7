package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.PurchasedLotto;
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
        outputView.printPurchaseAmount(purchasePrice.getQuantity());
        outputView.printPurchasedLottos(purchasedLotto.getPurchasedLottos());
        Lotto winningLotto = inputService.readWinningLotto();
        int bonusNum = inputService.readBonusNum();
    }

}
