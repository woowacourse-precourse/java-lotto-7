package lotto.results.listener;

import lotto.checker.event.BonusNumberCreatedEvent;
import lotto.results.application.ResultsService;
import lotto.results.domain.Results;
import lotto.results.dto.ResultsRequest;
import lotto.results.event.ResultsRequestCreatedEvent;
import lotto.shared.event.DomainEvent;
import lotto.shared.event.EventListener;
import lotto.shared.event.EventOrchestrator;
import lotto.shared.event.EventPublisher;

public class ResultsListener implements EventListener {

    EventPublisher eventPublisher;
    EventOrchestrator eventOrchestrator;
    ResultsService resultsService;

    public ResultsListener(EventPublisher eventPublisher,
                           EventOrchestrator eventOrchestrator,
                           ResultsService resultsService) {
        this.eventPublisher = eventPublisher;
        this.eventOrchestrator = eventOrchestrator;
        this.resultsService = resultsService;
    }

    @Override
    public void handle(DomainEvent event) {
        bonusNumberCreatedEvent(event);
    }

    private void bonusNumberCreatedEvent(DomainEvent event) {
        if (event instanceof BonusNumberCreatedEvent bonusNumberCreatedEvent) {
            eventOrchestrator.register(bonusNumberCreatedEvent);
            ResultsRequest resultRequest = eventOrchestrator.createResultRequest();
            Results results = resultsService.calculateResults(resultRequest);
            eventPublisher.publish(new ResultsRequestCreatedEvent(results));
        }
    }

}
