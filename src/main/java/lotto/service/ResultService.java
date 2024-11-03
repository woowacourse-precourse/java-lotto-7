package lotto.service;

import lotto.domain.calculator.MatchCounter;
import lotto.domain.calculator.PrizeCalculator;
import lotto.domain.calculator.ProfitCalculator;
import lotto.domain.calculator.RankCounter;
import lotto.domain.core.Bonus;
import lotto.domain.core.Lotto;
import lotto.domain.core.PurchaseTotalPrice;
import lotto.domain.core.Rank;
import lotto.dto.result.IssuedTickets;
import lotto.dto.result.MatchResults;
import lotto.dto.result.ProfitResult;
import lotto.dto.result.SortedIssuedTickets;
import lotto.utils.sorter.TicketSorter;
import lotto.view.OutputView;

import java.util.Map;

public class ResultService {
    private final OutputView outputView;

    public ResultService(OutputView outputView) {
        this.outputView = outputView;
    }

    public void processResults(IssuedTickets issuedTickets, Lotto lotto, Bonus bonus, PurchaseTotalPrice purchaseTotalPrice) {
        outputView.printWinningStatisticsHeader();

        SortedIssuedTickets sortedIssuedTickets = sortTickets(issuedTickets);
        MatchResults matchResults = calculateMatchResults(sortedIssuedTickets, lotto, bonus);
        Map<Rank, Integer> rankCounts = countRanks(matchResults);

        printRankStatistics(rankCounts);
        printProfitRate(rankCounts, purchaseTotalPrice);
    }

    private SortedIssuedTickets sortTickets(IssuedTickets issuedTickets) {
        return TicketSorter.getSortedTickets(issuedTickets);
    }

    private MatchResults calculateMatchResults(SortedIssuedTickets sortedIssuedTickets, Lotto lotto, Bonus bonus) {
        MatchCounter matchCounter = new MatchCounter(lotto, bonus);
        return matchCounter.calculateMatchResults(sortedIssuedTickets);
    }

    private Map<Rank, Integer> countRanks(MatchResults matchResults) {
        RankCounter rankCounter = new RankCounter();
        return rankCounter.countRanks(matchResults);
    }

    private void printRankStatistics(Map<Rank, Integer> rankCounts) {
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NO_MATCH) {
                outputView.printRankStatistics(rank, rankCounts.getOrDefault(rank, 0));
            }
        }
    }

    private void printProfitRate(Map<Rank, Integer> rankCounts, PurchaseTotalPrice purchaseTotalPrice) {
        int totalPrizeAmount = PrizeCalculator.calculateTotalPrize(rankCounts);
        ProfitResult profitResult = ProfitCalculator.calculateProfit(purchaseTotalPrice.totalPrice(), totalPrizeAmount);
        outputView.printProfitRate(profitResult.profitRate());
    }
}
