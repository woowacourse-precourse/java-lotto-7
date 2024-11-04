package lotto.config.controller.lottoStaticsController;

import lotto.config.io.OutputHandlerConfig;
import lotto.controller.lottoStaticsController.DefaultLottoStaticsController;
import lotto.controller.lottoStaticsController.LottoStaticsController;

public class DefaultLottoStaticsControllerConfig implements LottoStaticsControllerConfig {

    private final LottoStaticsController lottoStaticsController;

    public DefaultLottoStaticsControllerConfig(OutputHandlerConfig outputHandlerConfig) {
        this.lottoStaticsController = new DefaultLottoStaticsController(outputHandlerConfig.getOutputHandler());
    }

    @Override
    public LottoStaticsController getLottoStaticsController() {
        return this.lottoStaticsController;
    }
}
