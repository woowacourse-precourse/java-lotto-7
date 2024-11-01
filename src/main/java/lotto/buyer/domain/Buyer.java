package lotto.buyer.domain;

import lotto.money.domain.Money;

public class Buyer {
    private final InsertMoneyService insertMoneyService;
    public Buyer(InsertMoneyService insertMoneyService) {
        this.insertMoneyService= insertMoneyService;
    }
    public Money insertMoney() {
        return insertMoneyService.insert();
    }
}
