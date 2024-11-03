package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.common.PrintMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class OutputView {

    public void displayPurchasedTickets(List<Lotto> tickets) {
        System.out.println();
        System.out.printf(PrintMessage.PURCHASED_TICKETS_MESSAGE.getMessage(), tickets.size());

        tickets.forEach(ticket -> System.out.printf(PrintMessage.TICKET_NUMBERS_MESSAGE.getMessage(), ticket.getNumbers()));
    }

    public void displayResults(Map<LottoRank, Integer> results) {
        System.out.print(PrintMessage.RESULT_STATISTICS_HEADER.getMessage());

        LottoRank[] ranks = {LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FOURTH, LottoRank.FIFTH};
        for (LottoRank rank : ranks) {
            int count = results.getOrDefault(rank, 0);
            System.out.printf(PrintMessage.RANK_RESULT_MESSAGE.getMessage(),
                    rank.getMatchCount(), rank.getFormattedPrize(), count);
        }
    }


    public void displayProfitRate(double profitRate) {
        System.out.printf(PrintMessage.PROFIT_RATE_MESSAGE.getMessage(), profitRate);
    }

}
