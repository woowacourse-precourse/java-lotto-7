package lotto.service;

import lotto.domain.Money;

public class LottoService {
    public LottoService() {
    }

    public int getTicketCount(Money money) {
        return money.getValue() / 1000;
    }
}
