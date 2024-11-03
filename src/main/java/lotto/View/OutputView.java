package lotto.View;

import java.util.Arrays;
import java.util.List;
import lotto.Model.Lotto;
import lotto.Model.LottoResult;
import lotto.Model.Rank;

public class OutputView {

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers().toString()));
    }

    public static void printLottoResult(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        List<Rank> ranks = Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH);
        for (Rank rank : ranks) {
            System.out.printf("%d개 일치 (%d원) - %d개%n", rank.getMatchCount(), rank.getPrize(), result.getWinningCounts().getOrDefault(rank, 0));
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

}
