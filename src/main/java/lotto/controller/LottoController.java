package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private LottoService lottoService;

    public void run() {
        String purchaseAmount = InputView.getPurchaseAmount();
        int numberOfTickets = LottoService.calculateNumberOfLotteryTickets(purchaseAmount);
        List<List<Integer>> lotteryTickets = LottoService.makeLotteryTickets(numberOfTickets);
        OutputView.printLotteryTickets(lotteryTickets);
        String winningNumbers = InputView.getLotteryWinningNumbers();
        String lotteryNumber = InputView.getLotteryBonusNumber();

        InputView.closeConsole();
    }

}
