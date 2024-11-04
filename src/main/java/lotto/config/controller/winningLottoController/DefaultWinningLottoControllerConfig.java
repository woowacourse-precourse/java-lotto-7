package lotto.config.controller.winningLottoController;

import lotto.config.aop.RetryHandlerConfig;
import lotto.config.io.InputHandlerConfig;
import lotto.controller.winningLottoController.DefaultWinningLottoController;
import lotto.controller.winningLottoController.WinningLottoController;
import lotto.controller.winningLottoController.WinningLottoControllerRetryProxy;

public class DefaultWinningLottoControllerConfig implements WinningLottoControllerConfig {

    private final WinningLottoController winningLottoController;

    public DefaultWinningLottoControllerConfig(
            InputHandlerConfig inputHandlerConfig,
            RetryHandlerConfig retryHandlerConfig
    ) {
        DefaultWinningLottoController defaultWinningLottoController = new DefaultWinningLottoController(
                inputHandlerConfig.getInputHandler()
        );
        this.winningLottoController = new WinningLottoControllerRetryProxy(
                defaultWinningLottoController,
                retryHandlerConfig.getRetryHandler()
        );
    }

    @Override
    public WinningLottoController getWinningLottoController() {
        return this.winningLottoController;
    }
}
