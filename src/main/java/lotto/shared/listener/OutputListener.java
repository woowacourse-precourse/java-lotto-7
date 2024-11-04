package lotto.shared.listener;

import lotto.checker.event.WinningNumbersCreatedEvent;
import lotto.checker.event.BonusNumberCreatedEvent;
import lotto.results.domain.Results;
import lotto.results.event.ResultsRequestCreatedEvent;
import lotto.results.dto.ResultsRequest;
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
        if (event instanceof LottosCreatedEvent lottosCreatedEvent) {
            System.out.println("로또 생성 됐어: " + lottosCreatedEvent);
            eventOrchestrator.register(lottosCreatedEvent);
            outputService.showLotto(lottosCreatedEvent.getLottos());
            eventPublisher.publish(new ShowLottoEvent());
        }

        if (event instanceof ShowLottoEvent showLottoEvent) {
            System.out.println("결과 보여 줬어: " + showLottoEvent);
            outputService.showWinningNumbersPrompt();
            eventPublisher.publish(new ShowWinningNumbersPromptEvent());
        }

        if (event instanceof WinningNumbersCreatedEvent winningNumbersCreatedEvent) {
            System.out.println("번호 받았어: " + winningNumbersCreatedEvent);
            eventOrchestrator.register(winningNumbersCreatedEvent);
            outputService.showBonusNumberPrompt();
            eventPublisher.publish(new ShowBonusNumberPromptEvent());
        }

        if (event instanceof BonusNumberCreatedEvent bonusNumberCreatedEvent) {
            System.out.println("보너스 번호 받았어: " + bonusNumberCreatedEvent);
            eventOrchestrator.register(bonusNumberCreatedEvent);
            ResultsRequest resultRequest = eventOrchestrator.createResultRequest();
            Results results = resultsService.calculateResults(resultRequest);
            eventPublisher.publish(new ResultsRequestCreatedEvent(results));
        }

        if (event instanceof ResultsRequestCreatedEvent resultsRequestCreatedEvent) {
            System.out.println("결과 받았어: " + resultsRequestCreatedEvent);
            outputService.showResults(resultsRequestCreatedEvent.getResults(), eventOrchestrator.getMoney());
        }
    }
}
