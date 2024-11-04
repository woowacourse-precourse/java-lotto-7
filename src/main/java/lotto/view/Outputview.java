package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;

public class Outputview {
    public static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTickets.size());
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResults(List<Rank> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        int[] rankCounts = countRanks(results);
        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);

        for (Rank rank : ranks) {
            if (rank == Rank.NONE) {
                continue;
            }
            printRankResult(rank, rankCounts[rank.ordinal()]);
        }
    }

    private static int[] countRanks(List<Rank> results) {
        int[] rankCounts = new int[Rank.values().length];
        for (Rank rank : results) {
            rankCounts[rank.ordinal()]++;
        }
        return rankCounts;
    }

    private static void printRankResult(Rank rank, int count) {
        String bonusInfo = getBonusInfo(rank);
        String prizeFormatted = String.format("%,d", rank.getPrize());
        System.out.printf("%d개 일치%s (%s원) - %d개%n",
                rank.getMatchCount(), bonusInfo, prizeFormatted, count);
    }

    private static String getBonusInfo(Rank rank) {
        if (rank == Rank.SECOND) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}
