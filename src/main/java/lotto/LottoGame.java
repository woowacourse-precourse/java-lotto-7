package lotto;

import java.util.List;
import java.util.Map;
import lotto.system.formater.PrintFormatter;
import lotto.system.formater.winning.LottoWinningAnalyzer;
import lotto.system.formater.winning.WinningStatisticsFormatter;
import lotto.system.lottoGetter.LottoTicketIssuer;
import lotto.system.unit.LottoTicket;
import lotto.system.utils.PrizeType;
import lotto.user.Bonus;
import lotto.user.Lotto;

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