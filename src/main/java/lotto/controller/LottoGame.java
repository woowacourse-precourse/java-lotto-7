package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.view.PrintFormatter;
import lotto.service.winning.LottoWinningAnalyzer;
import lotto.service.winning.WinningStatisticsFormatter;
import lotto.service.lotto.LottoTicketIssuer;
import lotto.domain.value.LottoTicket;
import lotto.utils.PrizeType;
import lotto.domain.Bonus;
import lotto.domain.Lotto;

public class LottoGame {

    private final PrintFormatter printFormatter = new PrintFormatter();

    public static void start() {
        LottoGame game = new LottoGame();
        game.run();
    }

    private void run() {
        LottoTicketIssuer ticketIssuer = issueTickets();
        List<LottoTicket> issuedTickets = ticketIssuer.issueLottoTickets();
        displayTickets(issuedTickets, ticketIssuer.getQuantity());

        Lotto lotto = getWinningNumbers();
        Bonus bonus = getBonusNumber(lotto.getNumbers());

        Map<PrizeType, Integer> prizeStatistics = analyzeResults(issuedTickets, lotto, bonus);
        displayResults(prizeStatistics, ticketIssuer.getPurchaseAmount());
    }

    private LottoTicketIssuer issueTickets() {
        return printFormatter.handlePurchaseInfo();
    }

    private void displayTickets(List<LottoTicket> tickets, int quantity) {
        printFormatter.displayLottoTicketsWithQuantity(tickets, quantity);
    }

    private Lotto getWinningNumbers() {
        return printFormatter.handleWinningNumbers();
    }

    private Bonus getBonusNumber(List<Integer> winningNumbers) {
        return printFormatter.handleBonusNumber(winningNumbers);
    }

    private Map<PrizeType, Integer> analyzeResults(List<LottoTicket> issuedTickets, Lotto lotto, Bonus bonus) {
        LottoWinningAnalyzer analyzer = new LottoWinningAnalyzer(lotto.getNumbers(), bonus.getNumber());
        return analyzer.analyzeWinningStatistics(issuedTickets);
    }

    private void displayResults(Map<PrizeType, Integer> prizeStatistics, int purchaseAmount) {
        String formattedStatistics = WinningStatisticsFormatter.formatStatistics(prizeStatistics, purchaseAmount);
        printFormatter.displayResultWithNewLine(formattedStatistics);
    }
}