package lotto.config;

import lotto.purchase.listener.PurchaseListener;
import lotto.shared.event.EventOrchestrator;
import lotto.shared.event.EventPublisher;
import lotto.shared.listener.InputListener;
import lotto.shared.listener.OutputListener;
import lotto.results.listener.ResultsListener;
import lotto.shared.application.InputService;
import lotto.shared.application.OutputService;
import lotto.purchase.application.FortuneMachineService;
import lotto.results.application.ResultsService;

public class ListenerConfig {

    private final EventPublisher eventPublisher;
    private final PurchaseListener purchaseListener;
    private final OutputListener outputListener;
    private final InputListener inputListener;
    private final ResultsListener resultsListener;

    public ListenerConfig(EventPublisher eventPublisher,
                          EventOrchestrator eventOrchestrator,
                          FortuneMachineService fortuneMachineService,
                          InputService inputService,
                          OutputService outputService,
                          ResultsService resultsService) {
        this.eventPublisher = eventPublisher;
        this.purchaseListener = new PurchaseListener(eventPublisher, fortuneMachineService, eventOrchestrator);
        this.outputListener = new OutputListener(eventPublisher, eventOrchestrator, outputService, resultsService);
        this.inputListener = new InputListener(eventPublisher, eventOrchestrator, inputService);
        this.resultsListener = new ResultsListener(eventPublisher, eventOrchestrator, resultsService);

        registerListeners();
    }

    private void registerListeners() {
        eventPublisher.registerListener(purchaseListener);
        eventPublisher.registerListener(outputListener);
        eventPublisher.registerListener(inputListener);
        eventPublisher.registerListener(resultsListener);
    }
}
