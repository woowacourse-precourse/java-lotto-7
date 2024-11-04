package lotto.config;

import lotto.config.aop.RetryHandlerConfig;
import lotto.config.controller.moneyController.DefaultMoneyControllerConfig;
import lotto.config.controller.moneyController.MoneyControllerConfig;
import lotto.config.controller.winningLottoController.DefaultWinningLottoControllerConfig;
import lotto.config.controller.winningLottoController.WinningLottoControllerConfig;
import lotto.config.io.InputHandlerConfig;
import lotto.config.io.OutputHandlerConfig;
import lotto.config.io.reader.DefaultReaderConfig;
import lotto.config.io.reader.ReaderConfig;
import lotto.config.io.writer.DefaultWriterConfig;
import lotto.config.io.writer.WriterConfig;
import lotto.config.numberPicker.DefaultNumberPickerConfig;
import lotto.config.numberPicker.NumberPickerConfig;
import lotto.controller.LottoApplicationFacade;
import lotto.controller.lottoController.LottoController;
import lotto.controller.lottoStaticsController.LottoStaticsController;

public class LottoApplicationConfig {

    private final LottoApplicationFacade lottoApplicationFacade;

    public LottoApplicationConfig() {
        ReaderConfig readerConfig = new DefaultReaderConfig();
        WriterConfig writerConfig = new DefaultWriterConfig();

        InputHandlerConfig inputHandlerConfig = new InputHandlerConfig(readerConfig, writerConfig);
        OutputHandlerConfig outputHandlerConfig = new OutputHandlerConfig(writerConfig);
        RetryHandlerConfig retryHandlerConfig = new RetryHandlerConfig(outputHandlerConfig);
        NumberPickerConfig numberPickerConfig = new DefaultNumberPickerConfig();

        MoneyControllerConfig moneyControllerConfig = new DefaultMoneyControllerConfig(
                inputHandlerConfig,
                retryHandlerConfig
        );
        WinningLottoControllerConfig winningLottoControllerConfig = new DefaultWinningLottoControllerConfig(
                inputHandlerConfig,
                retryHandlerConfig
        );

        this.lottoApplicationFacade = new LottoApplicationFacade(
                moneyControllerConfig.getMoneyController(),
                new LottoController(outputHandlerConfig.getOutputHandler(), numberPickerConfig.getNumberPicker()),
                winningLottoControllerConfig.getWinningLottoController(),
                new LottoStaticsController(outputHandlerConfig.getOutputHandler())
        );
    }

    public LottoApplicationFacade getLottoApplicationFacade() {
        return this.lottoApplicationFacade;
    }
}
