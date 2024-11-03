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
        Bonus bonus = getBonusNumber();

        WinningResultCounter winningResultCounter = calculateWinningResults(tickets, winning, bonus);
        displayResults(winningResultCounter, ticketCount);
    }

    private TicketCount getTicketCount() {
        try {
            String readPurchaseAmount = inputView.readPurchaseAmount();
            int purchaseAmount = Integer.parseInt(readPurchaseAmount);
            TicketCount ticketCount = new TicketCount(purchaseAmount);
            outputView.printPurchaseTicketCount(ticketCount.getCount());
            return ticketCount;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getTicketCount();
        }
    }

    private Tickets generateTickets(TicketCount ticketCount) {
        try {
            Tickets tickets = new Tickets(ticketCount);
            List<String> ticketsInfo = tickets.getTicketsInfo();
            outputView.printTicketNumbers(ticketsInfo);
            return tickets;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return generateTickets(ticketCount);
        }
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

    private Bonus getBonusNumber() {
        try {
            String bonusNumber = inputView.readBonusNumber();
            return new Bonus(Integer.parseInt(bonusNumber));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getBonusNumber();
        }
    }

    private WinningResultCounter calculateWinningResults(Tickets tickets, Winning winning, Bonus bonus) {
        WinningResultCounter winningResultCounter = new WinningResultCounter();
        List<Lotto> lottos = tickets.getLottos();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winning.getLotto());
            boolean containsBonusBall = bonus.isContainsBonusBall(lotto);
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
        int purchaseAmount = ticketCount.getPurchaseAmount();
        return (double) totalProfit / purchaseAmount * 100;
    }
}