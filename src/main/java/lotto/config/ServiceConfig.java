package lotto.config;

import lotto.shared.application.InputService;
import lotto.shared.application.OutputService;
import lotto.purchase.application.FortuneMachineService;
import lotto.purchase.domain.FortuneMachine;
import lotto.results.application.ResultsService;
import lotto.shared.event.EventPublisher;
import lotto.view.InputView;
import lotto.view.InputViewImpl;
import lotto.view.OutputView;
import lotto.view.OutputViewImpl;

public class ServiceConfig {

    private InputService inputService;
    private OutputService outputService;
    private FortuneMachineService fortuneMachineService;
    private ResultsService resultsService;
    private InputView inputView;
    private OutputView outputView;

    private EventPublisher eventPublisher;

    public ServiceConfig(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public InputView getInputView() {
        if (inputView == null) {
            inputView = new InputViewImpl();
        }
        return inputView;
    }

    public OutputView getOutputView() {
        if (outputView == null) {
            outputView = new OutputViewImpl();
        }
        return outputView;
    }

    public InputService getInputService() {
        if (inputService == null) {
            inputService = new InputService(getInputView(), eventPublisher);
        }
        return inputService;
    }

    public OutputService getOutputService() {
        if (outputService == null) {
            outputService = new OutputService(getOutputView());
        }
        return outputService;
    }

    public ResultsService getResultsService() {
        if (resultsService == null) {
            resultsService = new ResultsService();
        }
        return resultsService;
    }

    public FortuneMachineService getFortuneMachineService() {
        if (fortuneMachineService == null) {
            fortuneMachineService = new FortuneMachineService(new FortuneMachine());
        }
        return fortuneMachineService;
    }
}