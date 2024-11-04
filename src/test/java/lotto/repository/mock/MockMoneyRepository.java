package lotto.repository.mock;

import java.util.Optional;
import lotto.domain.Money;
import lotto.repository.SingleRepository;

public class MockMoneyRepository implements SingleRepository<Money> {

    private final Money money;

    public MockMoneyRepository(Money money) {
        this.money = money;
    }

    @Override
    public Money save(Money object) {
        return object;
    }

    @Override
    public Optional<Money> get() {
        return Optional.ofNullable(this.money);
    }
}
