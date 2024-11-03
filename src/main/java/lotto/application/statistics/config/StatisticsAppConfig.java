package lotto.application.statistics.config;


import lotto.application.statistics.controller.StatisticsController;
import lotto.application.statistics.service.StatisticsWriteService;

public class StatisticsAppConfig {
    private final ControllerConfig controllerConfig;
    private final ServiceConfig serviceConfig;

    public StatisticsAppConfig() {
        this.serviceConfig = new ServiceConfig(
                getStatisticsWriteService()
        );
        this.controllerConfig = new ControllerConfig(
                serviceConfig.getStatisticsWriteService()
        );
    }

    public StatisticsController getStatisticsController() {
        return controllerConfig.getStatisticsController();
    }

    private StatisticsWriteService getStatisticsWriteService() {
        return new StatisticsWriteService();
    }

}
