package lotto;

import java.util.List;
import java.util.Map;

public class Print {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printStatistics(Map<LottoResult, Integer> statistics) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        for (LottoResult result : LottoResult.values()) {
            int count = statistics.get(result);
            System.out.printf("%s - %d개%n", result, count);
        }
    }

}
