package lotto.presentation;

import java.util.List;
import lotto.domain.LottoGame;
import lotto.domain.LottoGenerateStrategy;
import lotto.domain.Prize;
import lotto.domain.ProfitCalculator;
import lotto.domain.WinningTicket;

public class LottoController {
    private final LottoGenerateStrategy lottoGenerateStrategy;

    public LottoController(LottoGenerateStrategy lottoGenerateStrategy) {
        this.lottoGenerateStrategy = lottoGenerateStrategy;
    }

    public void run() {
        int money = InputView.getMoney();
        ProfitCalculator profitCalculator = new ProfitCalculator(money);
        WinningTicket winningTicket = getWinningTicketFromInput();
        LottoGame lottoGame = new LottoGame(profitCalculator, lottoGenerateStrategy, winningTicket);
        displayGameResults(lottoGame);
    }

    private void displayGameResults(LottoGame lottoGame) {
        displayPurchaseInfo(lottoGame);
        displayPrizeResults(lottoGame);
        displayEarningRate(lottoGame);
    }

    private WinningTicket getWinningTicketFromInput() {
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber(winningNumbers);
        return new WinningTicket(winningNumbers, bonusNumber);
    }

    private void displayPurchaseInfo(LottoGame lottoGame) {
        OutputView.printPurchaseAmount(lottoGame.getPurchasedTicketsCount());
        OutputView.printPurchasedLottos(lottoGame.getPurchasedTickets());
    }

    private void displayPrizeResults(LottoGame lottoGame) {
        List<Prize> prizes = lottoGame.getPrizes();
        LottoResultSummary resultSummary = new LottoResultSummary(prizes);
        OutputView.printResult(resultSummary.generateSummary());
    }

    private void displayEarningRate(LottoGame lottoGame) {
        float earningRate = lottoGame.calculateEarningRate();
        OutputView.printEarningRate(earningRate);
    }
}
