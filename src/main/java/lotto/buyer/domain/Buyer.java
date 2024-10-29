package lotto.buyer.domain;

public class Buyer {
    private final InsertMoneyService insertMoneyService;
    public Buyer(InsertMoneyService insertMoneyService) {
        this.insertMoneyService= insertMoneyService;
    }
    public Money insertMoney() {
        return insertMoneyService.insert();
    }
}
