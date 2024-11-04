package lotto;

import java.util.List;
import java.util.Map;

public class LottoOutput {
    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printResults(Map<String, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        results.forEach((rank, count) -> System.out.printf("%s - %d개\n", rank, count));
    }

    public void printProfit(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
