package lotto.config;

import lotto.controller.LottoController;
import lotto.shared.application.InputService;
import lotto.shared.application.OutputService;
import lotto.purchase.application.FortuneMachineService;
import lotto.results.application.ResultsService;
import lotto.shared.event.EventOrchestrator;
import lotto.shared.event.EventPublisher;
import lotto.view.InputView;
import lotto.view.OutputView;

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

    public InputView getInputView() {
        return serviceConfig.getInputView();
    }

    public OutputView getOutputView() {
        return serviceConfig.getOutputView();
    }

    public InputService getInputService() {
        return serviceConfig.getInputService();
    }

    public OutputService getOutputService() {
        return serviceConfig.getOutputService();
    }

    public ResultsService getResultsService() {
        return serviceConfig.getResultsService();
    }

    public FortuneMachineService getFortuneMachineService() {
        return serviceConfig.getFortuneMachineService();
    }

    public EventPublisher getEventPublisher() {
        return eventConfig.getEventPublisher();
    }

    public EventOrchestrator getEventOrchestrator() {
        return eventConfig.getEventOrchestrator();
    }

    public LottoController getLottoController() {
        return new LottoController(getInputService(), getEventPublisher());
    }
}
