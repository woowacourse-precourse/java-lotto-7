package lotto.controller;

import lotto.domain.Lottos;
import lotto.dto.PurchaseAmount;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        PurchaseAmount purchaseAmount = getValidLottoPurchaseAmount();
        Lottos lottos = new Lottos(purchaseAmount);
    }

    public PurchaseAmount getValidLottoPurchaseAmount() {
        try {
            PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.inputLottoPurchaseAmount());
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidLottoPurchaseAmount();
        }
    }
}
