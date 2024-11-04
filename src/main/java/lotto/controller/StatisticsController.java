package lotto.controller;

import lotto.service.StatisticsService;
import lotto.view.OutputView;

public class StatisticsController {

    private final StatisticsService statisticsService = new StatisticsService();

    public void getStatistic() {
        OutputView.printStatistics();
        statisticsService.start();
    }
}
