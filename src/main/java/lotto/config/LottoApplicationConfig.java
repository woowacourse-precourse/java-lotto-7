package lotto.config;

import lotto.config.aop.RetryHandlerConfig;
import lotto.config.controller.lottoController.DefaultLottoControllerConfig;
import lotto.config.controller.lottoController.LottoControllerConfig;
import lotto.config.controller.lottoStaticsController.DefaultLottoStaticsControllerConfig;
import lotto.config.controller.lottoStaticsController.LottoStaticsControllerConfig;
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
        LottoControllerConfig lottoControllerConfig = new DefaultLottoControllerConfig(
                outputHandlerConfig,
                numberPickerConfig
        );
        WinningLottoControllerConfig winningLottoControllerConfig = new DefaultWinningLottoControllerConfig(
                inputHandlerConfig,
                retryHandlerConfig
        );
        LottoStaticsControllerConfig lottoStaticsControllerConfig = new DefaultLottoStaticsControllerConfig(
                outputHandlerConfig
        );

        this.lottoApplicationFacade = new LottoApplicationFacade(
                moneyControllerConfig.getMoneyController(),
                lottoControllerConfig.getLottoController(),
                winningLottoControllerConfig.getWinningLottoController(),
                lottoStaticsControllerConfig.getLottoStaticsController()
        );
    }

    public LottoApplicationFacade getLottoApplicationFacade() {
        return this.lottoApplicationFacade;
    }
}
