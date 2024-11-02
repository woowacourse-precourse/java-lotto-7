package lotto.controller;

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
            printNumLotto(purchaseAmount);
        } catch (IllegalStateException e) {
            outputView.printExitMessage(e.getMessage());
        }
    }

    private void printNumLotto(long purchaseAmount) {
        long numLotto = NumLottoCalculator.calculate(purchaseAmount);
        outputView.printNumLotto(numLotto);
    }

    private long requestPurchaseAmount() {
        outputView.printPurchaseAmountRequestMessage();
        return inputView.readPurchaseAmount();
    }
}
