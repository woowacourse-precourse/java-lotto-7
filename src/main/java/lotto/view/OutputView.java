package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.Rank;
import lotto.model.Lotto;

public class OutputView {

    private final DecimalFormat df = new DecimalFormat("###,###");

    public void printPurchasedLottoAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningStatic(Map<Rank, Integer> lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            System.out.printf(getDisplayFormat(rank), rank.getMatchNumber(),
                df.format(rank.getPrize()),
                lottoResult.get(rank));
        }
    }

    private String getDisplayFormat(Rank rank) {
        if (rank == Rank.SECOND) {
            return "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n";
        }
        return "%d개 일치 (%s원) - %d개%n";
    }

    public void printEarningRate(float earningRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", earningRate);
    }

}
