package lotto.shared.listener;

import lotto.checker.event.WinningNumbersCreatedEvent;
import lotto.purchase.event.ShowMoneyPromptEvent;
import lotto.results.event.ResultsRequestCreatedEvent;
import lotto.shared.application.OutputService;
import lotto.results.application.ResultsService;
import lotto.shared.event.*;

public class OutputListener implements EventListener {

    EventPublisher eventPublisher;
    EventOrchestrator eventOrchestrator;
    OutputService outputService;
    ResultsService resultsService;

    public OutputListener(EventPublisher eventPublisher,
                          EventOrchestrator eventOrchestrator,
                          OutputService outputService,
                          ResultsService resultsService) {
        this.eventPublisher = eventPublisher;
        this.eventOrchestrator = eventOrchestrator;
        this.outputService = outputService;
        this.resultsService = resultsService;
    }

    @Override
    public void handle(DomainEvent event) {
        applicationStartEvent(event);
        lottosCreatedEvent(event);
        showLottoEvent(event);
        winningNumbersCreatedEvent(event);
        resultsRequestCreatedEvent(event);
    }

    private void applicationStartEvent(DomainEvent event) {
        if (event instanceof ApplicationStartEvent) {
            outputService.showMoneyPrompt();
            eventPublisher.publish(new ShowMoneyPromptEvent());
        }
    }



    private void lottosCreatedEvent(DomainEvent event) {
        if (event instanceof LottosCreatedEvent lottosCreatedEvent) {
            eventOrchestrator.register(lottosCreatedEvent);
            outputService.showLotto(lottosCreatedEvent.getLottos());
            eventPublisher.publish(new ShowLottoEvent());
        }
    }

    private void showLottoEvent(DomainEvent event) {
        if (event instanceof ShowLottoEvent showLottoEvent) {
            outputService.showWinningNumbersPrompt();
            eventPublisher.publish(new ShowWinningNumbersPromptEvent());
        }
    }

    private void winningNumbersCreatedEvent(DomainEvent event) {
        if (event instanceof WinningNumbersCreatedEvent winningNumbersCreatedEvent) {
            eventOrchestrator.register(winningNumbersCreatedEvent);
            outputService.showBonusNumberPrompt();
            eventPublisher.publish(new ShowBonusNumberPromptEvent());
        }
    }

    private void resultsRequestCreatedEvent(DomainEvent event) {
        if (event instanceof ResultsRequestCreatedEvent resultsRequestCreatedEvent) {
            outputService.showResults(resultsRequestCreatedEvent.getResults(), eventOrchestrator.getMoney());
        }
    }
}
