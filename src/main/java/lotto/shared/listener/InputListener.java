package lotto.shared.listener;

import lotto.checker.domain.BonusNumber;
import lotto.checker.domain.WinningNumbers;
import lotto.checker.event.BonusNumberCreatedEvent;
import lotto.checker.event.WinningNumbersCreatedEvent;
import lotto.shared.application.InputService;
import lotto.shared.event.*;

public class InputListener implements EventListener {

    EventPublisher eventPublisher;
    EventOrchestrator eventOrchestrator;
    InputService inputService;

    public InputListener(EventPublisher eventPublisher,
                         EventOrchestrator eventOrchestrator,
                         InputService inputService
    ) {
        this.eventPublisher = eventPublisher;
        this.inputService = inputService;
        this.eventOrchestrator = eventOrchestrator;
    }

    @Override
    public void handle(DomainEvent event) {
        if (event instanceof ShowWinningNumbersPromptEvent) {
            System.out.println("번호 받았어: ");
            WinningNumbers winningNumbers = inputService.getWinningNumbers();
            eventPublisher.publish(new WinningNumbersCreatedEvent(winningNumbers));
        }

        if (event instanceof ShowBonusNumberPromptEvent) {
            System.out.println("보너스 번호 받았어: ");
            BonusNumber bonusNumber = inputService.getBonusNumber(eventOrchestrator.getWinningNumbers());
            eventPublisher.publish(new BonusNumberCreatedEvent(bonusNumber));
        }

    }
}
