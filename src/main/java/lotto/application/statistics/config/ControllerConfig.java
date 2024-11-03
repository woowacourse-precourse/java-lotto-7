package lotto.application.statistics.config;

import lotto.application.statistics.controller.StatisticsController;
import lotto.application.statistics.service.StatisticsWriteService;

public class ControllerConfig {

    private final StatisticsController statisticsController;

    public ControllerConfig(StatisticsWriteService statisticsWriteService) {
        this.statisticsController = new StatisticsController(statisticsWriteService);
    }

    public StatisticsController getStatisticsController() {
        return statisticsController;
    }
    
}
