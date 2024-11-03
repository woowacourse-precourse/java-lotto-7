package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.TicketCount;
import lotto.domain.Tickets;
import lotto.domain.Winning;
import lotto.domain.WinningResult;
import lotto.domain.WinningResultCounter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String inputAmount = inputView.readPurchaseAmount();
        TicketCount ticket = new TicketCount(inputAmount);

        outputView.printTicketCount(ticket.getCount());
        Tickets tickets = new Tickets(ticket);
        List<String> ticketsInfo = tickets.getTicketsInfo();

        outputView.printTicketNumbers(ticketsInfo);

        String winningNumber = inputView.readWinningNumber();
        Winning winning = new Winning(winningNumber);

        String bonusNumber = inputView.readBonusNumber();
        Bonus bonus = new Bonus(Integer.parseInt(bonusNumber));

        WinningResultCounter winningResultCounter = new WinningResultCounter();

        List<Lotto> lottos = tickets.getLottos();
        for (Lotto lotto : lottos) {
            int counted = lotto.countMatchingNumbers(winning.getLotto());
            boolean containsBonusBall = bonus.isContainsBonusBall(lotto);

            WinningResult result = WinningResult.findByMatchCountAndBonus(counted, containsBonusBall);
            winningResultCounter.increment(result);
        }

        Map<WinningResult, Integer> winningResult = winningResultCounter.getWinningResult();
        int totalProfit = winningResult.entrySet().stream()
                .mapToInt(entry -> entry.getKey().calculateTotalWinningAmount(entry.getValue()))
                .sum();

        int purchaseAmount = Integer.parseInt(inputAmount);
        double profitRate = (double) totalProfit / purchaseAmount * 100;

        List<String> formattedResults = WinningResult.getFormattedResults(winningResult);

        outputView.printWinningStatistics(formattedResults);
        outputView.printProfitRate(profitRate);
    }
}