package lotto.config.controller.moneyController;

import lotto.config.aop.RetryHandlerConfig;
import lotto.config.io.InputHandlerConfig;
import lotto.controller.moneyController.DefaultMoneyController;
import lotto.controller.moneyController.MoneyController;
import lotto.controller.moneyController.MoneyControllerRetryProxy;

public class DefaultMoneyControllerConfig implements MoneyControllerConfig {

    private final MoneyController moneyController;

    public DefaultMoneyControllerConfig(
            InputHandlerConfig inputHandlerConfig,
            RetryHandlerConfig retryHandlerConfig
    ) {
        DefaultMoneyController defaultMoneyController = new DefaultMoneyController(
                inputHandlerConfig.getInputHandler()
        );
        this.moneyController = new MoneyControllerRetryProxy(
                defaultMoneyController,
                retryHandlerConfig.getRetryHandler()
        );
    }

    @Override
    public MoneyController getMoneyController() {
        return this.moneyController;
    }
}
