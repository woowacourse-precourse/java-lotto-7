package lotto.view.output;

import java.util.Arrays;
import java.util.List;
import lotto.config.LottoRank;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoResult;

public class OutputView {

    private OutputView() {
    }

    public static void printPurchaseCount(int count) {
        System.out.printf("\n%d개를 구매했습니다.\n", count);
    }

    public static void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.println(numbers.toString());
    }

    public static void printResult(LottoResult result) {
        System.out.println("\n당첨 통계\n---");
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .forEach(rank -> printRankResult(rank, result.getRankCounts().get(rank)));
    }

    private static void printRankResult(LottoRank rank, int count) {
        if (rank == LottoRank.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n",
                    rank.getMatchCount(),
                    rank.getPrize(),
                    count);
            return;
        }
        System.out.printf("%d개 일치 (%,d원) - %d개\n",
                rank.getMatchCount(),
                rank.getPrize(),
                count);
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}