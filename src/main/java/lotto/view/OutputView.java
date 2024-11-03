package lotto.view;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;

public class OutputView {

    public static void printPurchasedLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto ticket : lottoTickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public static void printWinningStatistics(Map<Rank, Integer> winningStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<Rank> sortedRanks = getSortedWinningRanks();
        for (Rank rank : sortedRanks) {
            printRankStatistics(rank, winningStatistics);
        }
    }

    private static List<Rank> getSortedWinningRanks() {
        List<Rank> ranks = new ArrayList<>();

        for (Rank rank : Rank.values()) {
            if (rank.isWinningRank()) {
                ranks.add(rank);
            }
        }

        ranks.sort(Comparator.comparingInt(Rank::getMatchCount));
        return ranks;
    }


    private static void printRankStatistics(Rank rank, Map<Rank, Integer> winningStatistics) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        StringBuilder result = new StringBuilder();

        result.append(rank.getMatchCount()).append("개 일치");
        if (rank.requiresBonus()) {
            result.append(", 보너스 볼 일치");
        }
        result.append(" (").append(numberFormat.format(rank.getPrize())).append("원) - ");
        result.append(winningStatistics.getOrDefault(rank, 0)).append("개");

        System.out.println(result);
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
