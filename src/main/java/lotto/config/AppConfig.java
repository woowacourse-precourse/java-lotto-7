package lotto.config;

import lotto.controller.ServerController;
import lotto.model.lotto.generator.LottoGenerator;
import lotto.model.lotto.generator.RandomLottoGenerator;
import lotto.service.CalculateService;
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

    public ServerController serverController() {
        return new ServerController(lottoService(), statisticService());
    }

    private LottoService lottoService() {
        return new LottoService(lottoGenerator());
    }

    private StatisticService statisticService() {
        return new StatisticService(calculateService());
    }

    private CalculateService calculateService() {
        return new CalculateService();
    }

    private LottoGenerator lottoGenerator() {
        return new RandomLottoGenerator();
    }
}
