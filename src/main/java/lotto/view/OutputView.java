package lotto.view;

import lotto.model.Lotto;
import lotto.model.Score;

import java.util.Arrays;
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
        Arrays.stream(Score.values()).forEach(score -> {
            if (!score.equals(Score.ZERO)) {
                printScore(score, scores.getOrDefault(score, 0));
            }
        });
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    private void printScore(Score score, int amount) {
        System.out.printf("%s (%s) - %s개\n", score.getMessage(), formatMoney(score.getPrize()), amount);
    }

    private String formatMoney(int amount) {
        return String.format("%,d원", amount);
    }
}
