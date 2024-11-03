package lotto;

import java.util.List;
import java.util.Map;

public class Print {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printStatistics(LottoStatistics statistics) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        for (LottoResult result : LottoResult.values()) {
            int count = statistics.getStatistics().get(result);
            System.out.printf("%s - %d개%n", result, count);
        }

        double yield = statistics.calculateYield();
        System.out.printf("총 수익률은 %.2f%%입니다.\n", yield);

    }

}
