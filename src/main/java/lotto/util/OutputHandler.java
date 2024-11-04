package lotto.util;

import java.util.Map;

public class OutputHandler {

    public static void printPurchaseInfo(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(Iterable<?> lottos) {
        lottos.forEach(System.out::println);
    }

    public static void printStatistics(Map<Integer, Integer> ranks, double rate) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + ranks.getOrDefault(5, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + ranks.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + ranks.getOrDefault(3, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ranks.getOrDefault(2, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + ranks.getOrDefault(1, 0) + "개");
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
