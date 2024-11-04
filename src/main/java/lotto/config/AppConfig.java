package lotto.config;

import lotto.shared.application.InputService;
import lotto.shared.application.OutputService;
import lotto.shared.event.EventOrchestrator;
import lotto.shared.event.EventPublisher;
import lotto.shared.listener.InputListener;
import lotto.shared.listener.OutputListener;
import lotto.controller.LottoController;
import lotto.checker.listener.CheckerListener;
import lotto.purchase.application.FortuneMachineService;
import lotto.purchase.domain.FortuneMachine;
import lotto.results.application.ResultsService;
import lotto.results.listener.ResultsListener;
import lotto.view.InputView;
import lotto.view.InputViewImpl;
import lotto.view.OutputView;
import lotto.view.OutputViewImpl;

import java.util.ArrayList;

public class AppConfig {

    private EventPublisher eventPublisher;
    private EventOrchestrator eventOrchestrator;

    private CheckerListener checkerListener;
    private OutputListener outputListener;
    private InputListener inputListener;
    private ResultsListener resultsListener;

    private FortuneMachineService fortuneMachineService;
    private OutputService outputService;
    private InputService inputService;
    private InputView inputView;
    private OutputView outputView;
    private ResultsService resultsService;

    public AppConfig() {
        initializeEventListeners();
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
            inputService = new InputService(getInputView());
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

    public FortuneMachine getFortuneMachine() {
        return new FortuneMachine();
    }

    public FortuneMachineService getFortuneMachineService() {
        if (fortuneMachineService == null) {
            fortuneMachineService = new FortuneMachineService(getFortuneMachine());
        }
        return fortuneMachineService;
    }

    public EventPublisher getEventPublisher() {
        if (eventPublisher == null) {
            eventPublisher = new EventPublisher(new ArrayList<>());
            // `LottoListener` 추가는 별도 메서드에서 수행
        }
        return eventPublisher;
    }

    public EventOrchestrator getEventOrchestrator() {
        if (eventOrchestrator == null) {
            eventOrchestrator = new EventOrchestrator();
        }
        return eventOrchestrator;
    }

    public CheckerListener getCheckerListener() {
        if (checkerListener == null) {
            checkerListener = new CheckerListener(getEventPublisher(), getFortuneMachineService(), getEventOrchestrator());
            getEventPublisher().registerListener(checkerListener);
        }
        return checkerListener;
    }

    public OutputListener getOutputListener () {
        if (outputListener == null) {
            outputListener = new OutputListener(getEventPublisher(), getEventOrchestrator(), getOutputService(), getResultsService());
            getEventPublisher().registerListener(outputListener);
        }
        return outputListener;
    }

    public InputListener getInputListener () {
        if (inputListener == null) {
            inputListener = new InputListener(getEventPublisher(), getEventOrchestrator(), getInputService());
            getEventPublisher().registerListener(inputListener);
        }
        return inputListener;
    }

    public ResultsListener getResultsListener () {
        if (resultsListener == null) {
            resultsListener = new ResultsListener(getEventPublisher(), getEventOrchestrator(), getOutputService());
            getEventPublisher().registerListener(resultsListener);
        }
        return resultsListener;
    }

    private void initializeEventListeners() {
        getCheckerListener();
        getOutputListener();
        getInputListener();
        getResultsListener();
    }

    public LottoController getLottoController() {
        return new LottoController(getInputService(), getEventPublisher());
    }
}
