package lotto.purchase.event;

import lotto.shared.event.DomainEvent;
import lotto.purchase.domain.Money;

public class MoneyCreatedEvent implements DomainEvent {
    private final Money money;

    public MoneyCreatedEvent(Money money) {
        this.money = money;
    }

    public Money getMoney() {
        return money;
    }
}
