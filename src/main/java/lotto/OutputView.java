package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println();
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto ->
                System.out.println(lotto.getNumbers()));
        System.out.println();
    }

    public void printResult(Map<LottoRank, Integer> results , double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .forEach(rank -> printWinningResult(rank, results.getOrDefault(rank, 0)));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private void printWinningResult(LottoRank rank, int count) {
        System.out.printf("%s - %d개%n", rank, count);
    }
}
