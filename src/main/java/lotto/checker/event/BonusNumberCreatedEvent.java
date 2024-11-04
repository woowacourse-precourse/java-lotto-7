package lotto.checker.event;

import lotto.checker.domain.BonusNumber;
import lotto.shared.event.DomainEvent;

public class BonusNumberCreatedEvent implements DomainEvent {
    private final BonusNumber bonusNumber;

    public BonusNumberCreatedEvent(BonusNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
