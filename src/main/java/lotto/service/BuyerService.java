package lotto.service;

import static lotto.constant.LottoGameRule.LOTTO_COST;

import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;

public class BuyerService {
    public int calculateLottoQuantity(String input) {
        Money money = createMoney(input);
        int price = money.getPrice();

        return price / LOTTO_COST.getValue();
    }

    public WinningNumbers createWinningNumbers(String input) {
        return new WinningNumbers(input);
    }

    public BonusNumber createBonusNumber(WinningNumbers winningNumbers, String input) {
        return new BonusNumber(winningNumbers, input);
    }

    private Money createMoney(String input) {
        return new Money(input);
    }
}
