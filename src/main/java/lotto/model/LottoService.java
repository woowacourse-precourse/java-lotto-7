package lotto.model;

import lotto.view.MoneyInputView;

public class LottoService {

    private final MoneyInputView moneyInputView = new MoneyInputView();

    public Money getMoney() {
        String inputMoney = moneyInputView.inputMoney();
        int money = Integer.parseInt(inputMoney);

        return new Money(money);
    }
}
