package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.StatisticsService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        StatisticsService statisticsService = new StatisticsService();
        LottoController controller = new LottoController(lottoService, statisticsService);

        controller.run();
    }
}
