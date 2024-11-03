package lotto.view;

import java.io.PrintStream;
import java.util.List;
import java.util.SequencedMap;
import lotto.domain.Rank;

public class OutputView {

    public static void printPurchaseCount(int count) {
        System.out.println("\n"+count + "개를 구매했습니다.");
    }

    public static void printLottoTickets(List<List<Integer>> lottoTickets) {
        for (List<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
        System.out.println();
    }

    public static void printWinningStatistics() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    public static void printWinningResults(SequencedMap<Rank, Integer> results) {
        for (Rank rank : Rank.values()) {
            int count = results.get(rank);
            if (rank == Rank.NONE) {
                continue;
            }

            if (rank == Rank.FIVE_AND_BONUS) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n",
                        rank.getMatchCount(), formatCurrency(rank.getPrize()), count);
                continue;
            }

            System.out.printf("%d개 일치 (%s원) - %d개%n",
                    rank.getMatchCount(), formatCurrency(rank.getPrize()), count);
        }
    }

    public static void printProfitRate(String formattedProfitRate) {
        System.out.printf("총 수익률은 %s입니다.", formattedProfitRate);
    }

    private static String formatCurrency(long amount) {
        return String.format("%,d", amount);
    }

    public static void printErrorMessage(String errorMessage) {
        System.err.println("ERROR: " + errorMessage);
    }
}
