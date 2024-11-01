package lotto.controller;

import lotto.service.PurchaseService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final PurchaseService purchaseService = new PurchaseService();

    public void purchaseLotto() {
        int price = inputView.getPrice();

        int lottoCount = purchaseService.buyLotto(price);
        outputView.printPurchaseResult(lottoCount);

        //수량만큼 로또 발부
        runLottoMachine(lottoCount);
    }

    public void runLottoMachine(int lottoCount) {

    }
}
