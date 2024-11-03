package lotto.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoConstants;
import lotto.model.Rank;

public class StatisticsCalculator {

    public static Map<Rank, Integer> calculateWinningStatistics(List<Lotto> lottoTickets,
                                                                List<Integer> winningNumbers,
                                                                int bonusNumber) {
        return lottoTickets.stream()
                .map(ticket -> RankCalculator.calculateRank(ticket, winningNumbers, bonusNumber))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.summingInt(rank -> 1)));
    }

    public static double calculateTotalWinningProfitRate(Map<Rank, Integer> winningStatistics, int purchaseAmount) {
        int totalPrize = calculateTotalPrize(winningStatistics);
        return calculatePercentageRate(totalPrize, purchaseAmount);
    }

    private static int calculateTotalPrize(Map<Rank, Integer> winningStatistics) {
        return winningStatistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private static double calculatePercentageRate(int totalPrize, int purchaseAmount) {
        if (purchaseAmount < LottoConstants.PRICE_PER_TICKET.getValue()) {
            return 0.0; // 기본 수익률 반환
        }
        return (double) totalPrize / purchaseAmount * 100;
    }

}
