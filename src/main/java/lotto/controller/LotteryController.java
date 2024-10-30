package lotto.controller;

import lotto.Lotto;
import lotto.domain.Money;
import lotto.io.view.InputView;

public class LotteryController {
    public void run() {
        InputView inputView = new InputView();
        Money amountOfMoney = inputView.getAmountOfMoney();
        Lotto winningNumbers = inputView.getWinningNumbers();
    }
}
