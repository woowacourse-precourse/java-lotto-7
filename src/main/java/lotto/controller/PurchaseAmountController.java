package lotto.controller;

import lotto.dto.PurchaseAmountRequestDto;
import lotto.service.handler.PurchaseAmountHandler;
import lotto.view.InputView;

public class PurchaseAmountController {
    public static PurchaseAmountRequestDto run() {
        String purchaseAmount = InputView.requestLottoPurchase();
        PurchaseAmountHandler.handle(purchaseAmount);
        return new PurchaseAmountRequestDto(Integer.parseInt(purchaseAmount));
    }
    public static void restart() {
        run();
    }
}
