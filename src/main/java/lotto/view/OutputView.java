package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoList;
import lotto.model.Score;
import java.util.Map;

public class OutputView {

    public static void printLottoList(LottoList lottoList) {
        System.out.printf("%d개를 구매했습니다.%n", lottoList.getLottoList().size());
        for (Lotto lotto : lottoList.getLottoList()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printLottoStatistics(Map<Score, Integer> resultCount, int purchaseAmount) {
        System.out.println("당첨 통계\n---");
        for (Score score : Score.values()) {
            if (score == Score.ZERO) {
                continue;
            }
            if (score == Score.SECONDPLACE) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", score.getMatchCount(), score.getMoney(), resultCount.getOrDefault(score, 0));
                continue;
            }
                System.out.printf("%d개 일치 (%,d원) - %d개%n", score.getMatchCount(), score.getMoney(), resultCount.getOrDefault(score, 0));


        }
        printProfitRate(resultCount, purchaseAmount);
    }
    private static void printProfitRate(Map<Score, Integer> resultCount, int purchaseAmount) {
        double totalProfit = 0;

        for (Score score : resultCount.keySet()) {
            int count = resultCount.get(score);
            totalProfit += score.getMoney() * count;
        }
        double profitRate = (totalProfit / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
