package lotto.controller;

import lotto.dto.PurchaseAmountRequestDto;
import lotto.service.handler.PurchaseAmountHandler;
import lotto.view.InputView;

public class PurchaseAmountController {
    public static PurchaseAmountRequestDto run() {
        String purchaseAmount = "";
        boolean isValid = false;
        while (!isValid) {
            purchaseAmount= InputView.requestLottoPurchase();
            isValid = PurchaseAmountHandler.handle(purchaseAmount);
        }
        return new PurchaseAmountRequestDto(Integer.parseInt(purchaseAmount));
    }
}
