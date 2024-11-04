package lotto.results.event;

import lotto.shared.event.DomainEvent;
import lotto.results.domain.Results;

public class ResultsRequestCreatedEvent implements DomainEvent {

    private final Results results;

    public ResultsRequestCreatedEvent(Results results) {
        this.results = results;
    }

    public Results getResults() {
        return results;
    }
}
