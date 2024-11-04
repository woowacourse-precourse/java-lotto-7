package lotto.controller;

import lotto.model.LottoPurchase;
import lotto.service.LottoGameService;
import lotto.validator.LottoPurchaseValidator;
import lotto.view.InputView;

public class LottoGameController {
    private final LottoGameService lottoGameService = new LottoGameService();

    public void run() {
        LottoPurchase lottoPurchase = inputPurchaseAmount();
    }

    private LottoPurchase inputPurchaseAmount() {
        while (true) {
            try {
                String input = InputView.inputPurchaseAmount();
                int purchaseAmount = LottoPurchaseValidator.validateAndParse(input);
                return lottoGameService.createLottoPurchase(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
