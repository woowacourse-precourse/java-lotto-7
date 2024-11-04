package lotto;

import lotto.controller.LottoController;
import lotto.controller.PurchaseAmountController;
import lotto.controller.ResultController;
import lotto.controller.StatisticsController;
import lotto.model.Statistics;
import lotto.service.LottoService;
import lotto.service.PurchaseAmountService;
import lotto.service.ResultService;
import lotto.service.StatisticsService;
import lotto.view.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PurchaseAmountService purchaseAmountService = new PurchaseAmountService();
        PurchaseAmountController purchaseAmountController = new PurchaseAmountController(purchaseAmountService);

        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(lottoService);

        ResultService resultService = new ResultService();
        ResultController resultController = new ResultController(resultService);

        Statistics statistics = new Statistics();
        StatisticsService statisticsService = new StatisticsService(statistics);
        StatisticsController statisticsController = new StatisticsController(statisticsService);

        OutView outView = new OutView(lottoController, purchaseAmountController, resultController, statisticsController);
        outView.start();
    }
}
