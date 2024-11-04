package lotto.service;

import java.util.List;
import lotto.model.Result;
import lotto.model.Statistics;

public class StatisticsService {
    private final Statistics statistics;

    public StatisticsService(Statistics statistics) {
        this.statistics = statistics;
    }

    public void compareNumbers(List<List<Integer>> userNumbersList, Result result) {
        List<Integer> winningNumbers = result.getWinningNumber();

        for (List<Integer> userNumbers : userNumbersList) {
            int matchCount = 0;
            boolean isBonus = false;

            for (Integer number : userNumbers) {
                if (winningNumbers.contains(number)) {
                    matchCount++;
                }
            }

            if (matchCount==5 && userNumbers.contains(result.getBonusNumber())) {
                isBonus = true;
            }

            statistics.updateStatistics(matchCount, isBonus);
        }
    }

    public String getStatistics(int purchasedTickets) {
        System.out.println();
        StringBuilder summary = new StringBuilder();
        summary.append("당첨 통계\n");
        summary.append("---\n");
        summary.append(String.format("3개 일치 (5,000원) - %d개\n", statistics.getMatchCount("3개 일치")));
        summary.append(String.format("4개 일치 (50,000원) - %d개\n", statistics.getMatchCount("4개 일치")));
        summary.append(String.format("5개 일치 (1,500,000원) - %d개\n", statistics.getMatchCount("5개 일치")));
        summary.append(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", statistics.getMatchCount("5개 일치, 보너스 볼 일치")));
        summary.append(String.format("6개 일치 (2,000,000,000원) - %d개\n", statistics.getMatchCount("6개 일치")));

        double totalPriceRate = statistics.getTotalPriceRate(purchasedTickets);
        summary.append(String.format("총 수익률은 %.1f%%입니다.\n", totalPriceRate));

        return summary.toString();
    }

}
