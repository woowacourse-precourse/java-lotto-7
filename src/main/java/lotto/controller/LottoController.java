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
        TicketCount ticketCount = getTicketCount();
        Tickets tickets = generateTickets(ticketCount);
        Winning winning = getWinningNumbers();
        Bonus bonus = getBonusNumber(winning);

        WinningResultCounter winningResultCounter = calculateWinningResults(tickets, winning, bonus);
        displayResults(winningResultCounter, ticketCount);
    }

    private TicketCount getTicketCount() {
        try {
            String amount = inputView.readPurchaseAmount();

            TicketCount ticketCount = new TicketCount(amount);

            outputView.printPurchaseTicketCount(ticketCount.getCount());

            return ticketCount;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getTicketCount();
        }
    }

    private Tickets generateTickets(TicketCount ticketCount) {
        Tickets tickets = new Tickets(ticketCount.getCount());
        List<String> ticketsInfo = tickets.getTicketsInfo();
        outputView.printTicketNumbers(ticketsInfo);
        return tickets;
    }

    private Winning getWinningNumbers() {
        try {
            String winningNumber = inputView.readWinningNumber();

            return new Winning(winningNumber);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getWinningNumbers();
        }
    }

    private Bonus getBonusNumber(Winning winning) {
        try {
            String bonusNumber = inputView.readBonusNumber();

            return new Bonus(bonusNumber, winning.getLotto());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getBonusNumber(winning);
        }
    }

    private WinningResultCounter calculateWinningResults(Tickets tickets, Winning winning, Bonus bonus) {
        WinningResultCounter winningResultCounter = new WinningResultCounter();
        List<Lotto> lottos = tickets.getLottos();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winning.getLotto());
            boolean containsBonusBall = bonus.containsBonusBall(lotto);
            WinningResult result = WinningResult.findByMatchCountAndBonus(matchCount, containsBonusBall);
            winningResultCounter.increment(result);
        }

        return winningResultCounter;
    }

    private void displayResults(WinningResultCounter winningResultCounter, TicketCount ticketCount) {
        Map<WinningResult, Integer> winningResult = winningResultCounter.getWinningResult();
        int totalProfit = calculateTotalProfit(winningResult);
        double profitRate = calculateProfitRate(totalProfit, ticketCount);

        List<String> formattedResults = WinningResult.getFormattedResults(winningResult);
        outputView.printWinningStatistics(formattedResults);
        outputView.printProfitRate(profitRate);
    }

    private int calculateTotalProfit(Map<WinningResult, Integer> winningResult) {
        return winningResult.entrySet().stream()
                .mapToInt(entry -> entry.getKey().calculateTotalWinningAmount(entry.getValue()))
                .sum();
    }

    private double calculateProfitRate(int totalProfit, TicketCount ticketCount) {
        int purchaseAmount = ticketCount.getAmount();
        return (double) totalProfit / purchaseAmount * 100;
    }
}
