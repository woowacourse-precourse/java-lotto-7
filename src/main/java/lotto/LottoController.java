package lotto;

import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoController {
    public void start() {
        int money = InputView.getMoneyToBuy();
        int amount = money / 1000;
        OutputView.printBlankLine();
        OutputView.notifyAmount(amount);
    }
}
