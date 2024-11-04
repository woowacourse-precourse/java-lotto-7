package lotto.results.listener;

import lotto.results.event.ResultsRequestCreatedEvent;
import lotto.shared.event.DomainEvent;
import lotto.shared.event.EventListener;
import lotto.shared.event.EventOrchestrator;
import lotto.shared.event.EventPublisher;
import lotto.shared.application.OutputService;

public class ResultsListener implements EventListener {

    EventPublisher eventPublisher;
    EventOrchestrator eventOrchestrator;
    OutputService outputService;

    public ResultsListener(EventPublisher eventPublisher,
                           EventOrchestrator eventOrchestrator,
                           OutputService outputService) {
        this.eventPublisher = eventPublisher;
        this.eventOrchestrator = eventOrchestrator;
        this.outputService = outputService;
    }

    @Override
    public void handle(DomainEvent event) {
        if (event instanceof ResultsRequestCreatedEvent resultsRequestCreatedEvent) {
            System.out.println("결과 생성 됨: " + resultsRequestCreatedEvent);
            outputService.showResults(resultsRequestCreatedEvent.getResults(), eventOrchestrator.getMoney());
        }

    }
}
