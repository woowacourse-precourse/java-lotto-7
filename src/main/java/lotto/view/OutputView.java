package lotto.view;

import lotto.service.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String DIVIDER = "---";
    public static void printPurchasedLottoTickets(List<List<Integer>> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (List<Integer> ticket : lottoTickets) {
            ticket.sort(Integer::compareTo);
            System.out.println(ticket);
        }
    }

    public static void printLottoStatistics(Map<LottoRank, Integer> rankCounts) {
        System.out.println("당첨 통계");
        System.out.println(DIVIDER);

        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                System.out.printf("%d개 일치%s (%d원) - %d개%n",
                        rank.getMatchCount(),
                        getBonusText(rank),
                        rank.getPrize(),
                        rankCounts.getOrDefault(rank, 0));
            }
        }
    }

    private static String getBonusText(LottoRank rank) {
        if (rank == LottoRank.SECOND) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    public static void printRevenueRate(double revenueRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", revenueRate);
    }
}
