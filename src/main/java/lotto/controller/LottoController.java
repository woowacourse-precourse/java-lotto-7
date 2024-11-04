package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    private LottoService lottoService;
    
    public void run() {
        String purchaseAmount = InputView.getPurchaseAmount();
        lottoService.calculateNumberOfLotteryTickets(purchaseAmount);
        String winningNumbers = InputView.getLotteryWinningNumbers();
        String lotteryNumber = InputView.getLotteryBonusNumber();

        InputView.closeConsole();
    }

}
