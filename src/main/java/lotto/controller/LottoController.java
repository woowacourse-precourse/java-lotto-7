package lotto.controller;

import lotto.service.PurchaseService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final PurchaseService purchaseService = new PurchaseService();

    public void lottoPurchase() {
        int price = inputView.getPrice();

        int lottoCount = purchaseService.buyLotto(price);
        outputView.printPurchaseResult(lottoCount);

        lottoMachineRun(lottoCount);
    }

    public void lottoMachineRun(int lottoCount) {

    }
}
