package lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class Application {
    public static void main(String[] args) {
        // 당첨 통계 확인
        System.out.println();
        Map<Integer, Integer> ranks = checkWinningRank(numberOfMatches);
        double rateOfReturn = calculateRateOfReturn(ranks, payment);
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }




    public static Map<Integer, Integer> checkWinningRank(List<Integer> numberOfMatches) {
        int firstRank = Collections.frequency(numberOfMatches, 6);
        int secondRank = Collections.frequency(numberOfMatches, 10);
        int thirdRank = Collections.frequency(numberOfMatches, 5);
        int fourthRank = Collections.frequency(numberOfMatches, 4);
        int fifthRank = Collections.frequency(numberOfMatches, 3);

        Map<Integer, Integer> ranks = new HashMap<>(5);
        ranks.put(firstRank, 2_000_000_000);
        ranks.put(secondRank, 3_000_000);
        ranks.put(thirdRank, 1_500_000);
        ranks.put(fourthRank, 50_000);
        ranks.put(fifthRank, 5_000);

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifthRank + "개");
        System.out.println("4개 일치 (50,000원) - " + fourthRank + "개");
        System.out.println("5개 일치 (1,500,000원) - " + thirdRank + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondRank + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + firstRank + "개");

        return ranks;
    }

    public static double calculateRateOfReturn(Map<Integer, Integer> ranks, int payment) {
        double sum = 0;
        for (int numberOfWinning : ranks.keySet()) {
            sum += numberOfWinning * ranks.get(numberOfWinning);
        }

        sum /= payment;
        sum *= 100;

        return Math.round(sum * 100) / 100.0;
    }
}
