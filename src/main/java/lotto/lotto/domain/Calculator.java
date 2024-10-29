package lotto.lotto.domain;

import lotto.buyer.domain.Money;

public interface Calculator {
    int divideByThousand(Money money);
}
