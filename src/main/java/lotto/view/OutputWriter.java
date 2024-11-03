package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputWriter {

    public void printLottoNumbers(int lottoCount, List<Set<Integer>> totalLottoNumbers) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Set<Integer> lottoNumbers : totalLottoNumbers) {
            System.out.println(lottoNumbers);
        }
    }

    public void printWinningStatistics(String winningRate, Map<Integer, Integer> totalMatchCounts, int bonusCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + totalMatchCounts.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + totalMatchCounts.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + totalMatchCounts.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + bonusCount + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + totalMatchCounts.get(6) + "개");
        System.out.println("총 수익률은 " + winningRate + "%입니다.");
    }
}
