package lotto.presentation;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoGame;
import lotto.domain.LottoGenerateStrategy;
import lotto.domain.LottoTicketBundle;
import lotto.domain.Prize;
import lotto.domain.UserAccount;
import lotto.domain.WinningTicket;

public class LottoController {
    private final LottoGenerateStrategy lottoGenerateStrategy;

    public LottoController(LottoGenerateStrategy lottoGenerateStrategy) {
        this.lottoGenerateStrategy = lottoGenerateStrategy;
    }

    public void run() {
        UserAccount userAccount = UserAccount.of(InputView.getMoney());
        LottoTicketBundle ticketBundle = purchaseTickets(userAccount.getTicketCount());
        WinningTicket winningTicket = getWinningTicketFromInput();
        LottoGame lottoGame = new LottoGame(userAccount, ticketBundle, winningTicket);
        displayGameResults(lottoGame);
    }

    private LottoTicketBundle purchaseTickets(int ticketCount) {
        LottoTicketBundle ticketBundle = LottoTicketBundle.from(lottoGenerateStrategy, ticketCount);
        displayPurchaseInfo(ticketBundle);
        return ticketBundle;
    }

    private void displayPurchaseInfo(LottoTicketBundle ticketBundle) {
        OutputView.printPurchaseAmount(ticketBundle.size());
        OutputView.printPurchasedLottos(ticketBundle.toString());
    }

    private WinningTicket getWinningTicketFromInput() {
        List<Integer> winningNumbers = parseToIntegerList(InputView.getWinningNumbers());
        String bonusNumber = InputView.getBonusNumber(winningNumbers);
        return new WinningTicket(winningNumbers, Integer.parseInt(bonusNumber));
    }

    private List<Integer> parseToIntegerList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private void displayGameResults(LottoGame lottoGame) {
        displayPrizeResults(lottoGame);
        displayEarningRate(lottoGame);
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
