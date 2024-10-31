package lotto.controller;

import lotto.domain.vo.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputMessage;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount amount = receivePurchaseAmount();
    }

    private PurchaseAmount receivePurchaseAmount() {
        outputView.print(OutputMessage.INPUT_PURCHASE_AMOUNT.getMessage());
        try {
            return PurchaseAmount.from(inputView.readLine());
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return receivePurchaseAmount();
        }
    }
}
