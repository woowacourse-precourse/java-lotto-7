package lotto.shared.application;

import lotto.checker.domain.BonusNumber;
import lotto.purchase.domain.Money;
import lotto.checker.domain.WinningNumbers;
import lotto.purchase.event.MoneyCreatedEvent;
import lotto.shared.event.EventPublisher;
import lotto.view.InputView;

public class InputService {

    private final InputView inputView;
    private final EventPublisher eventPublisher;

    public InputService(InputView inputView, EventPublisher eventPublisher) {
        this.inputView = inputView;
        this.eventPublisher = eventPublisher;
    }

    public Money getMoney() {
        return inputView.getMoney();
    }

    public WinningNumbers getWinningNumbers() {
        return inputView.getWinningNumbers();
    }

    public BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        return inputView.getBonusNumber(winningNumbers);
    }

    public void start(Money money) {
        eventPublisher.publish(new MoneyCreatedEvent(money));
    }
}
