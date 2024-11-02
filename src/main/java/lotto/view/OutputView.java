package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final String PURCHASE_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_RANK_FORMAT = "%s (%d원) - %d개";

    public void printPurchaseCount(int count) {
        System.out.printf((PURCHASE_COUNT_FORMAT) + "%n", count);
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    public void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Arrays.stream(Rank.values())
                .forEach(rank -> printRankCount(rank, lottoResult.getCountByRank(rank)));
    }

    private void printRankCount(Rank rank, int count) {
        if(rank == Rank.NONE) {
            return;
        }

        System.out.printf((WINNING_RANK_FORMAT) + "%n",
                rank.getDescription(),
                rank.getPrize(),
                count);
    }
}
