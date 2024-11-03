package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoOutputView {
    public void printPurchaseResult(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printWinningStatistics(Map<WinningRank, Integer> statistics, double returnRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        Arrays.stream(WinningRank.values())
                .filter(rank -> rank != WinningRank.NONE)
                .forEach(rank -> printWinningRank(rank, statistics.getOrDefault(rank, 0)));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnRate);
    }

    private void printWinningRank(WinningRank rank, int count) {
        System.out.printf("%s (%,d원) - %d개\n",
                rank.getDescription(),
                rank.getPrize(),
                count);
    }

    public void printError(String message) {
        System.out.println(message);
    }


}
