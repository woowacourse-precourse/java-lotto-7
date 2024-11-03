package lotto.controller;

import lotto.model.LottoPurchaseDetails;
import lotto.util.NumLottoCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachineController {
    private InputView inputView;
    private OutputView outputView;

    public LottoMachineController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            long purchaseAmount = requestPurchaseAmount();
            LottoPurchaseDetails lottoPurchaseDetails = new LottoPurchaseDetails(calcNumLotto(purchaseAmount));
            displayPurchaseDetails(lottoPurchaseDetails);
        } catch (IllegalStateException e) {
            outputView.printExitMessage(e.getMessage());
        }
    }

    private void displayPurchaseDetails(LottoPurchaseDetails lottoPurchaseDetails) {
        String purchaseDetailsMessage = lottoPurchaseDetails.getPurchaseDetailsMessage();
        outputView.printPurchaseDetailsMessage(purchaseDetailsMessage);
    }

    private long calcNumLotto(long purchaseAmount) {
        return NumLottoCalculator.calculate(purchaseAmount);
    }

    private long requestPurchaseAmount() {
        outputView.printPurchaseAmountRequestMessage();
        return inputView.readPurchaseAmount();
    }
}
