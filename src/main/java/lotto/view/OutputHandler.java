package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Score;

public class OutputHandler {
    public void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.printf("%s개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printLottosResult(Map<Score, Integer> scoreCount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Score score : Score.getWinningScores()) {
            int count = scoreCount.getOrDefault(score, 0);
            System.out.printf("%s - %d개%n", score.getPrintMessage(), count);
        }
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }
}
