package lotto.outputview;

import lotto.core.LottoResult;

import java.util.List;

public class LottoStatisticsOutputView {
    public static void printStatistics(List<LottoResult> results) {
        int[] prizeCounts = new int[6]; // 0: 3개, 1: 4개, 2: 5개, 3: 5개 + 보너스, 4: 6개

        for (LottoResult result : results) {
            int matchCount = result.getMatchCount();
            boolean isBonusMatched = result.isMatch();

            if (matchCount == 3) {
                prizeCounts[0]++;
            } else if (matchCount == 4) {
                prizeCounts[1]++;
            } else if (matchCount == 5 && isBonusMatched) {
                prizeCounts[3]++;
            } else if (matchCount == 5) {
                prizeCounts[2]++;
            } else if (matchCount == 6) {
                prizeCounts[4]++;
            }
        }

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", prizeCounts[0]);
        System.out.printf("4개 일치 (50,000원) - %d개%n", prizeCounts[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", prizeCounts[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", prizeCounts[3]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", prizeCounts[4]);
    }
}
