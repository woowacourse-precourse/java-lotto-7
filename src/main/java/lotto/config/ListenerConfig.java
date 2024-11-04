package lotto.config;

import lotto.shared.event.EventOrchestrator;
import lotto.shared.event.EventPublisher;
import lotto.shared.listener.InputListener;
import lotto.shared.listener.OutputListener;
import lotto.checker.listener.CheckerListener;
import lotto.results.listener.ResultsListener;
import lotto.shared.application.InputService;
import lotto.shared.application.OutputService;
import lotto.purchase.application.FortuneMachineService;
import lotto.results.application.ResultsService;

public class ListenerConfig {

    private final EventPublisher eventPublisher;
    private final CheckerListener checkerListener;
    private final OutputListener outputListener;
    private final InputListener inputListener;
    private final ResultsListener resultsListener;

    public ListenerConfig(EventPublisher eventPublisher, EventOrchestrator eventOrchestrator,
                          FortuneMachineService fortuneMachineService, InputService inputService,
                          OutputService outputService, ResultsService resultsService) {
        this.eventPublisher = eventPublisher;
        this.checkerListener = new CheckerListener(eventPublisher, fortuneMachineService, eventOrchestrator);
        this.outputListener = new OutputListener(eventPublisher, eventOrchestrator, outputService, resultsService);
        this.inputListener = new InputListener(eventPublisher, eventOrchestrator, inputService);
        this.resultsListener = new ResultsListener(eventPublisher, eventOrchestrator, resultsService);

        registerListeners();
    }

    private void registerListeners() {
        eventPublisher.registerListener(checkerListener);
        eventPublisher.registerListener(outputListener);
        eventPublisher.registerListener(inputListener);
        eventPublisher.registerListener(resultsListener);
    }

    public CheckerListener getCheckerListener() {
        return checkerListener;
    }

    public OutputListener getOutputListener() {
        return outputListener;
    }

    public InputListener getInputListener() {
        return inputListener;
    }

    public ResultsListener getResultsListener() {
        return resultsListener;
    }
}
