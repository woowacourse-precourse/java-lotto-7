package lotto.repository.impl;

import java.util.Optional;
import lotto.domain.Money;
import lotto.repository.SingleRepository;

public class MoneyRepository implements SingleRepository<Money> {

    private Money money;

    @Override
    public void save(Money money) {
        this.money = money;
    }

    @Override
    public Optional<Money> get() {
        return Optional.ofNullable(money);
    }
}
