package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void displayLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void displayLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            sortedNumbers.sort(null);
            System.out.println(sortedNumbers);
        }
    }

    public void displayResults(Map<Rank, Integer> lottoStats, double profitRate) {

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoStats.getOrDefault(Rank.FIFTH, 0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoStats.getOrDefault(Rank.FOURTH, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoStats.getOrDefault(Rank.THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoStats.getOrDefault(Rank.SECOND, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoStats.getOrDefault(Rank.FIRST, 0));

        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
