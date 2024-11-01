package lotto.view;

import lotto.model.Lotto;
import lotto.model.Score;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("\n%d개를 구매했습니다.%n", lottos.size());

        lottos.forEach(this::printLotto);
    }

    public void printScores(Map<Score, Integer> scores) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%,d원) - %d개%n", Score.THREE.getPrize(),
                scores.getOrDefault(Score.THREE, 0));

        System.out.printf("4개 일치 (%,d원) - %d개%n", Score.FOURTH.getPrize(),
                scores.getOrDefault(Score.FOURTH, 0));

        System.out.printf("5개 일치 (%,d원) - %d개%n", Score.FIFTH.getPrize(),
                scores.getOrDefault(Score.FIFTH, 0));

        System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개%n", Score.FIFTH_WITH_BONUS.getPrize(),
                scores.getOrDefault(Score.FIFTH_WITH_BONUS, 0));

        System.out.printf("6개 일치 (%,d원) - %d개%n", Score.SIX.getPrize(),
                scores.getOrDefault(Score.SIX, 0));
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}
