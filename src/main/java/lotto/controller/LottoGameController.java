package lotto.controller;

import lotto.model.LottoPurchase;
import lotto.service.LottoGameService;
import lotto.view.InputView;

public class LottoGameController {
    private final LottoGameService lottoGameService = new LottoGameService();

    public void run() {
        LottoPurchase lottoPurchase = inputPurchaseAmount();
    }

    private LottoPurchase inputPurchaseAmount() {
        while (true) {
            try {
                int purchaseAmount = InputView.inputPurchaseAmount();
                return lottoGameService.createLottoPurchase(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
