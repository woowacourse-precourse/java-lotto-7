package lotto.controller;

import lotto.service.LottoService;
import lotto.service.PurchaseService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void purchaseLotto() {
        PurchaseService purchaseService = new PurchaseService();
        int price = inputView.getPrice();
        int lottoCount = purchaseService.buyLotto(price);

        outputView.printPurchaseResult(lottoCount);
        makeLotto(lottoCount);
    }

    public void makeLotto(int lottoCount) {
        LottoService lottoService = new LottoService();
        lottoService.makeLotto(lottoCount);
        lottoService.printLottoNumbers();
    }
}
