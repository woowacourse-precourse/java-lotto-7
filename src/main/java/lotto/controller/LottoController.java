package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        String purchaseAmount = InputView.getPurchaseAmount();
        lottoService.calculateNumberOfLotteryTickets(purchaseAmount);
        String winningNumbers = InputView.getLotteryWinningNumbers();
        String lotteryNumber = InputView.getLotteryBonusNumber();

        InputView.closeConsole();
    }

}
