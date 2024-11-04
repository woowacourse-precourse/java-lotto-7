package lotto.view;

import lotto.Lotto;
import lotto.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printStatistics(Map<Rank, Integer> results, double yield) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : Rank.values()) {
            printRank(rank, results);
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    private void printRank(Rank rank, Map<Rank, Integer> results) {
        if (rank == Rank.MISS) {
            return;
        }

        if (rank == Rank.SECOND) {
            System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                    rank.getMatchCount(), formatPrize(rank.getPrize()), results.getOrDefault(rank, 0)));
            return;
        }

        System.out.println(String.format("%d개 일치 (%s원) - %d개",
                rank.getMatchCount(), formatPrize(rank.getPrize()), results.getOrDefault(rank, 0)));
    }

    private String formatPrize(int prize) {
        return String.format("%,d", prize);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
