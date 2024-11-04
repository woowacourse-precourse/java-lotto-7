package lotto.config.controller.lottoController;

import lotto.config.io.OutputHandlerConfig;
import lotto.config.numberPicker.NumberPickerConfig;
import lotto.controller.lottoController.DefaultLottoController;
import lotto.controller.lottoController.LottoController;

public class DefaultLottoControllerConfig implements LottoControllerConfig {

    private final LottoController lottoController;

    public DefaultLottoControllerConfig(
            OutputHandlerConfig outputHandlerConfig,
            NumberPickerConfig numberPickerConfig
    ) {
        this.lottoController = new DefaultLottoController(
                outputHandlerConfig.getOutputHandler(),
                numberPickerConfig.getNumberPicker()
        );
    }

    @Override
    public LottoController getLottoController() {
        return this.lottoController;
    }
}
