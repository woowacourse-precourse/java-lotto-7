package lotto.service;

import static lotto.constant.LottoGameRule.LOTTO_COST;

import lotto.domain.Money;

public class BuyerService {
    public int calculateLottoQuantity(String input) {
        Money money = createMoney(input);
        int price = money.getPrice();

        return price / LOTTO_COST.getValue();
    }

    private Money createMoney(String input) {
        return new Money(input);
    }
}
