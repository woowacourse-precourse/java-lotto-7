package lotto.controller.moneyController;

import lotto.domain.Money;
import lotto.io.InputHandler;

public class DefaultMoneyController implements MoneyController {

    private final InputHandler inputHandler;

    public DefaultMoneyController(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    @Override
    public Money readMoney() {
        int amount = inputHandler.handlePurchaseCost();
        return Money.from(amount);
    }
}
