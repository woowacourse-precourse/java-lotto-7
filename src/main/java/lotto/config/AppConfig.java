package lotto.config;

import lotto.controller.MainController;
import lotto.io.terminal.InputTerminal;
import lotto.io.terminal.OutputTerminal;
import lotto.model.lotto.generator.LottoGenerator;
import lotto.model.lotto.generator.RandomLottoGenerator;
import lotto.service.LottoService;
import lotto.service.StatisticService;

public class AppConfig {

    private AppConfig() {
    }

    public static class AppConfigHolder {
        private static final AppConfig INSTANCE = new AppConfig();
    }

    public static AppConfig getInstance() {
        return AppConfigHolder.INSTANCE;
    }

    public MainController serverController() {
        return new MainController(
                inputTerminal(),
                outputTerminal(),
                lottoService(),
                statisticService()
        );
    }

    private InputTerminal inputTerminal() {
        return InputTerminal.getInstance();
    }

    private OutputTerminal outputTerminal() {
        return OutputTerminal.getInstance();
    }


    private LottoService lottoService() {
        return new LottoService(lottoGenerator());
    }

    private StatisticService statisticService() {
        return new StatisticService();
    }

    private LottoGenerator lottoGenerator() {
        return new RandomLottoGenerator();
    }
}
