package lotto.controller.moneyController;

import lotto.aop.RetryHandler;
import lotto.domain.Money;

public class MoneyControllerRetryProxy implements MoneyController {

    private final MoneyController target;
    private final RetryHandler retryHandler;

    public MoneyControllerRetryProxy(MoneyController target, RetryHandler retryHandler) {
        this.target = target;
        this.retryHandler = retryHandler;
    }

    @Override
    public Money readMoney() {
        return retryHandler.tryUntilSuccess(target::readMoney);
    }
}
