package lotto.checker.event;

import lotto.checker.domain.WinningNumbers;
import lotto.shared.event.DomainEvent;

public class WinningNumbersCreatedEvent implements DomainEvent {

    private final WinningNumbers winningNumbers;

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public WinningNumbersCreatedEvent(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }
}
