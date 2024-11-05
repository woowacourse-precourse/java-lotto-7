package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import java.util.List;

public class OutputView {
    public void printPurchaseAmount(int amount) {
        System.out.printf("%d개를 구매했습니다.\n", amount / 1000);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printResults(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                printRankResult(rank, result.getRankCount().get(rank));
            }
        }

        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.calculateProfitRate());
    }

    private void printRankResult(Rank rank, int count) {
        System.out.printf("%s - %d개\n", rank.getDescription(), count);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}