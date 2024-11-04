package lotto.controller;

import lotto.dto.PurchaseAmountDTO;
import lotto.view.InputView;

public class LottoController {
    private static void getValidLottoPurchaseAmount() {
        try {
            PurchaseAmountDTO purchaseAmountDTO = new PurchaseAmountDTO(InputView.inputLottoPurchaseAmount());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getValidLottoPurchaseAmount();
        }
    }
}
