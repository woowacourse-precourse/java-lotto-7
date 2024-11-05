package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Ranking;

import java.util.List;
import java.util.Map;

public abstract class OutputView {

    public static void printPurchasedLottos(int lottoCount, List<Lotto> purchasedLottos) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        purchasedLottos.forEach(lotto -> {
            System.out.println(lotto.toString());
        });
    }

    public static void printWinningStatistics(Map<Ranking, Integer> rankingMap) {
        System.out.println("당첨 통계");
        System.out.println("---");
        rankingMap.forEach((ranking, count) -> {
            if (ranking.equals(Ranking.SECOND)) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", ranking.getMatchingCount(), ranking.getPrize(), count);
            }
            if (ranking.equals(Ranking.NONE)) {
                return;
            }
            System.out.printf("%d개 일치 (%,d원) - %d개\n", ranking.getMatchingCount(), ranking.getPrize(), count);
        });
    }

    public static void printEarningRate(double earningRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", earningRate);
    }

    public static void lineBreaking() {
        System.out.println();
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
