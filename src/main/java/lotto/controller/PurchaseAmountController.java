package lotto.controller;

import lotto.service.PurchaseAmountService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class PurchaseAmountController {

    private final InputView inputView;
    private final OutputView outputView;
    private final PurchaseAmountService purchaseAmountService;

    public PurchaseAmountController(
            InputView inputView, OutputView outputView, PurchaseAmountService purchaseAmountService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.purchaseAmountService = purchaseAmountService;
    }

    public void run() {
        while (true) {
            try {
                inputView.printPurchaseAmountInput();
                purchaseAmountService.save(inputView.getInput());

                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }


}
