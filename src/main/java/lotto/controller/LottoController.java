package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void play() {
        OutputView.printAskMoneyMessage();
        Money money = new Money(InputView.inputMoney());
    }
}
