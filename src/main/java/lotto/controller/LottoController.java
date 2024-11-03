package lotto.controller;

import lotto.info.LottoInfo;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        int money = InputView.getMoneyToBuy();
        int amount = money / LottoInfo.PRICE.getNumber();
        OutputView.printBlankLine();
        OutputView.notifyAmount(amount);
    }
}
