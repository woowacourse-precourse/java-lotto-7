package lotto.service;

import static lotto.constant.LottoGameRule.LOTTO_COST;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.utils.InputParser;

public class UserService {
    public int calculateLottoQuantity(String input) {
        Money money = createMoney(input);
        int price = money.getPrice();

        return price / LOTTO_COST.getValue();
    }

    public Lotto createWinningLotto(String input) {
        return new Lotto(InputParser.parseNumbers(input));
    }

    public BonusNumber createBonusNumber(Lotto winningLotto, String input) {
        return new BonusNumber(winningLotto, input);
    }

    private Money createMoney(String input) {
        return new Money(input);
    }
}
