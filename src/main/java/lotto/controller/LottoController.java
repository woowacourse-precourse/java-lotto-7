package lotto.controller;

import lotto.model.Money;
import lotto.view.MoneyInputView;
import lotto.view.OutView;

public class LottoController {

    OutView outView = new OutView();

    public void start() {

        Money money = userMoneyInput();

    }

    public Money userMoneyInput() {
        while (true) {
            try {
                Long number = MoneyInputView.getMoney();
                return new Money(number);
            } catch (IllegalArgumentException e) {
                outView.printErrorMessage(e.getMessage());
            }
        }
    }
}
