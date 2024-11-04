package lotto.application.statistics.config;

import lotto.application.statistics.service.StatisticsWriteService;

public class ServiceConfig {

    private final StatisticsWriteService statisticsWriteService;

    public ServiceConfig(StatisticsWriteService statisticsWriteService) {
        this.statisticsWriteService = statisticsWriteService;
    }

    public StatisticsWriteService getStatisticsWriteService() {
        return statisticsWriteService;
    }
}
