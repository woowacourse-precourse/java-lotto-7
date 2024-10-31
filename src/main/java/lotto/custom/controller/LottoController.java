package lotto.custom.controller;

import lotto.custom.service.LottoPurchaseService;
import lotto.custom.view.InputView;

public class LottoController {
    private final InputView inputView;
    private final LottoPurchaseService lottoPurchaseService;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoPurchaseService = new LottoPurchaseService();
    }

    public void run() {
        while (true) {
            try {
                String purchaseAmountInput = inputView.inputPurchaseAmount();
                lottoPurchaseService.run(purchaseAmountInput);
                break; // 예외가 발생하지 않으면 루프 종료
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}