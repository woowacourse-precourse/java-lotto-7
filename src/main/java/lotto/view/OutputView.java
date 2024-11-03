package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printPickNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printResult(Map<Prize, Integer> prizeCountMap, double returnRate) {
        System.out.println("당첨 결과:");
        System.out.println("3개 일치 (5,000원) - " + prizeCountMap.getOrDefault(Prize.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeCountMap.getOrDefault(Prize.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeCountMap.getOrDefault(Prize.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeCountMap.getOrDefault(Prize.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeCountMap.getOrDefault(Prize.FIRST, 0) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.%n", returnRate);
    }

}
