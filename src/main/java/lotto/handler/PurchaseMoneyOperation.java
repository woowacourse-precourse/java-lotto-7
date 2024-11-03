package lotto.handler;

import lotto.domain.PurchaseMoney;
import lotto.view.InputView;

public class PurchaseMoneyOperation implements Operation<PurchaseMoney> {
    private final InputView inputView;

    public PurchaseMoneyOperation(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public PurchaseMoney execute() throws IllegalArgumentException {
        return new PurchaseMoney(inputView.insertNumber());
    }
}
