package lotto.controller;

import lotto.domain.*;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.WinningResult;
import lotto.util.PrizeCalculator;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

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
        printPurchaseAmountAndLotto(purchasePrice.getQuantity(), purchasedLotto.getPurchasedLottos());

        Lotto winningLottoNumbers = inputService.readWinningLotto();
        int bonusNum = inputService.readBonusNum();
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNum);

        LottoResult lottoResult = new LottoResult(purchasedLotto.getPurchasedLottos(), winningLotto);
        double rate = PrizeCalculator.calcRate(purchasePrice.getPurchasePrice(), lottoResult.getTotalAmount());
        printResult(lottoResult.getResults(), rate);
    }

    private void printPurchaseAmountAndLotto(int quantity, List<Lotto> purchasedLotto) {
        outputView.printPurchaseAmount(quantity);
        outputView.printPurchasedLottos(purchasedLotto);
    }

    private void printResult(Map<WinningResult, Integer> results, double rate) {
        outputView.printLottoResults(results);
        outputView.printTotalRate(rate);
    }

}
