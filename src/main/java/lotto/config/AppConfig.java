package lotto.config;

import lotto.controller.LottoController;

public class AppConfig {

    private final  EventConfig eventConfig;
    private final  ServiceConfig serviceConfig;
    private final  ListenerConfig listenerConfig;

    public AppConfig() {
        eventConfig = new EventConfig();
        serviceConfig = new ServiceConfig(eventConfig.getEventPublisher());
        listenerConfig = new ListenerConfig(
                eventConfig.getEventPublisher(),
                eventConfig.getEventOrchestrator(),
                serviceConfig.getFortuneMachineService(),
                serviceConfig.getInputService(),
                serviceConfig.getOutputService(),
                serviceConfig.getResultsService()
        );
    }

    public LottoController getLottoController() {
        return new LottoController(eventConfig.getEventPublisher());
    }
}
