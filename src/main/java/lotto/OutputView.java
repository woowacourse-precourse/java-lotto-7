package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다." );
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningStatistics(Map<LottoRank, Integer> statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NO_PRIZE) continue;
            if (rank == LottoRank.SECOND_PRIZE) {
                System.out.printf(
                        "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n",
                        rank.getMatchCount(),
                        formatPrize(rank.getPrizeAmount()),
                        statistics.getOrDefault(rank, 0)
                );
                continue;
            }

            System.out.printf(
                    "%d개 일치 (%s원) - %d개%n",
                    rank.getMatchCount(),
                    formatPrize(rank.getPrizeAmount()),
                    statistics.getOrDefault(rank, 0)
            );
        }
    }

    private static String formatPrize(int prizeAmount) {
        return String.format("%,d", prizeAmount); // 상금을 1,000 단위로 콤마 추가
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.2f%%입니다.%n", rateOfReturn);
    }
}
