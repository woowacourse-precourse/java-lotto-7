package lotto.controller;

import java.util.List;
import lotto.model.Result;
import lotto.service.StatisticsService;

public class StatisticsController {
    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public String getWinningStatistics(int ticketCount) {
        return statisticsService.getStatistics(ticketCount);
    }

    public void updateStatistics(List<List<Integer>> userNumbersList, Result result) {
        statisticsService.compareNumbers(userNumbersList, result);
    }
}
