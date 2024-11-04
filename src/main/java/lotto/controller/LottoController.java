package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    public void run() {
        String purchaseAmount = InputView.getPurchaseAmount();
        String winningNumbers = InputView.getLotteryWinningNumbers();
        String lotteryNumber = InputView.getLotteryBonusNumber();

        InputView.closeConsole();
    }
    
}
