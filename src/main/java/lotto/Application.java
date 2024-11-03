package lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // 당첨 통계 확인
        System.out.println();
        Map<Integer, Integer> ranks = checkWinningRank(numberOfMatches);
        double rateOfReturn = calculateRateOfReturn(ranks, payment);
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
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
