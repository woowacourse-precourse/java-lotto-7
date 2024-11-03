package lotto.controller;

import lotto.service.LotteryMachineService;
import lotto.service.PurchaseAmountService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class PurchaseAmountController {

    private final InputView inputView;
    private final OutputView outputView;
    private final PurchaseAmountService purchaseAmountService;
    private final LotteryMachineService lotteryMachineService;

    public PurchaseAmountController(InputView inputView, OutputView outputView,
                                    PurchaseAmountService purchaseAmountService,
                                    LotteryMachineService lotteryMachineService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.purchaseAmountService = purchaseAmountService;
        this.lotteryMachineService = lotteryMachineService;
    }

    public void run() {
        insert();
        buy();
    }

    private void insert() {
        while (true) {
            try {
                inputView.printPurchaseAmountInput();
                purchaseAmountService.save(inputView.getInput());
                outputView.printEmptyLine();

                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void buy() {
        StringBuilder sb = new StringBuilder();
        lotteryMachineService.buy(sb);
        outputView.print(sb.toString());
    }
}
