package lotto;

import java.util.List;

public class OutputView {
    public static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(Statistics statistics) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + statistics.getFifthPrizeCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics.getFourthPrizeCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics.getThirdPrizeCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics.getSecondPrizeCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics.getFirstPrizeCount() + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.%n", statistics.getRateOfReturn());
    }
}
