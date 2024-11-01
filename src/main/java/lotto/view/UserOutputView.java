package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.Map;

public class UserOutputView {

    private static final String STATISTICS_MESSAGE = "당첨 통계";
    private static final String STATISTICS_DIVIDER = "---";

    public static void outputLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void outputWinningStatistics(Map<String, Integer> statistics) {
        System.out.println(STATISTICS_MESSAGE);
        System.out.println(STATISTICS_DIVIDER);
        System.out.println("3개 일치 (5,000원) - " + statistics.getOrDefault("5등", 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics.getOrDefault("4등", 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics.getOrDefault("3등", 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics.getOrDefault("2등", 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics.getOrDefault("1등", 0) + "개");
    }

    public static void outputProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
