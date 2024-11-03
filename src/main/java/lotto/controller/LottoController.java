package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.service.PurchaseService;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private final PurchaseService purchaseService;

    public LottoController(InputView inputView, PurchaseService purchaseService) {
        this.inputView = inputView;
        this.purchaseService = purchaseService;
    }

    public void run () {
        Integer purchaseAmount = lottoPurchase();
    }

    private Integer lottoPurchase () {
        String rawPurchaseAmount = inputView.getPurchaseAmount();

        return purchaseService.purchaseLotto(rawPurchaseAmount);
    }


}
