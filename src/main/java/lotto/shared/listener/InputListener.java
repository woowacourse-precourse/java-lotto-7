package lotto.shared.listener;

import lotto.checker.domain.BonusNumber;
import lotto.checker.domain.WinningNumbers;
import lotto.checker.event.BonusNumberCreatedEvent;
import lotto.checker.event.WinningNumbersCreatedEvent;
import lotto.purchase.domain.Money;
import lotto.purchase.event.MoneyCreatedEvent;
import lotto.purchase.event.ShowMoneyPromptEvent;
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
        showMoneyPromptEvent(event);
        showWinningNumbersPromptEvent(event);
        showBonusNumberPromptEvent(event);
    }

    private void showMoneyPromptEvent(DomainEvent event) {
        if (event instanceof ShowMoneyPromptEvent) {
            Money money = inputService.getMoney();
            eventPublisher.publish(new MoneyCreatedEvent(money));
        }
    }

    private void showWinningNumbersPromptEvent(DomainEvent event) {
        if (event instanceof ShowWinningNumbersPromptEvent) {
            WinningNumbers winningNumbers = inputService.getWinningNumbers();
            eventPublisher.publish(new WinningNumbersCreatedEvent(winningNumbers));
        }
    }

    private void showBonusNumberPromptEvent(DomainEvent event) {
        if (event instanceof ShowBonusNumberPromptEvent) {
            BonusNumber bonusNumber = inputService.getBonusNumber(eventOrchestrator.getWinningNumbers());
            eventPublisher.publish(new BonusNumberCreatedEvent(bonusNumber));
        }
    }
}
