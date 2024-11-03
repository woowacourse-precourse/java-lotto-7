package lotto.presentation;

import java.util.List;
import lotto.domain.LottoGame;
import lotto.domain.LottoGenerateStrategy;
import lotto.domain.LottoTicketBundle;
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
        LottoTicketBundle ticketBundle = purchaseTickets(profitCalculator.getTicketCount());
        WinningTicket winningTicket = getWinningTicketFromInput();
        LottoGame lottoGame = new LottoGame(profitCalculator, ticketBundle, winningTicket);
        displayGameResults(lottoGame);
    }

    private LottoTicketBundle purchaseTickets(int ticketCount) {
        LottoTicketBundle ticketBundle = LottoTicketBundle.from(lottoGenerateStrategy, ticketCount);
        displayPurchaseInfo(ticketBundle);
        return ticketBundle;
    }

    private void displayGameResults(LottoGame lottoGame) {
        displayPrizeResults(lottoGame);
        displayEarningRate(lottoGame);
    }

    private WinningTicket getWinningTicketFromInput() {
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber(winningNumbers);
        return new WinningTicket(winningNumbers, bonusNumber);
    }

    private void displayPurchaseInfo(LottoTicketBundle ticketBundle) {
        OutputView.printPurchaseAmount(ticketBundle.size());
        OutputView.printPurchasedLottos(ticketBundle.toString());
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
