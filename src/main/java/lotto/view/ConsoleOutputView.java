package lotto.view;

import lotto.constant.LottoConstants;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;
import java.util.List;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printPurchaseAmount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    @Override
    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    @Override
    public void printResult(LottoResult result) {
        System.out.println("\n당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                printRankResult(rank, result.getCountByRank(rank));
            }
        }
    }

    private void printRankResult(Rank rank, int count) {
        if (rank == Rank.SECOND) {
            System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개%n",
                    rank.getPrize(), count);
            return;
        }
        System.out.printf("%d개 일치 (%,d원) - %d개%n",
                rank.getMatchCount(), rank.getPrize(), count);
    }

    @Override
    public void printProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profit);
    }

    @Override
    public void printError(String message) {
        System.out.println(LottoConstants.ERROR_PREFIX + message);
    }
}
