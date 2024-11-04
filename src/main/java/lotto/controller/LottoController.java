package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        int purchaseAmount = InputView.getPurchaseAmount();
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
        OutputView.printLottoTickets(lottoMachine.generateLottos());

        String winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();

        lottoMachine.calculateResults(winningNumbers, bonusNumber);
        OutputView.printStatistics(lottoMachine.getStatistics());
    }
}
