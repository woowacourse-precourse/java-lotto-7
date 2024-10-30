package lotto.controller;

import lotto.dto.PurchaseMoneyRequest;
import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.Retryable;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Money money = retryIfHasError(this::getMoney);
    }

    private Money getMoney() {
        PurchaseMoneyRequest purchaseMoneyRequest = inputView.readMoneyInput();
        return new Money(purchaseMoneyRequest);
    }

    private <T> T retryIfHasError(Retryable<T> retryable) {
        while (true) {
            try {
                return retryable.execute();
            } catch (Exception e) {
                outputView.showErrorMessage(e);
            }
        }
    }
}
