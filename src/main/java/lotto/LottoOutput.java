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
        System.out.printf("3개 일치 (5,000원) - %d개\n", results.getOrDefault("5등", 0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", results.getOrDefault("4등", 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", results.getOrDefault("3등", 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", results.getOrDefault("2등", 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", results.getOrDefault("1등", 0));
    }

    public void printProfit(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
