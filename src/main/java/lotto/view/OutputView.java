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
        System.out.printf("%s - %d개\n", Rank.FIFTH.getDescription(), lottoStats.getOrDefault(Rank.FIFTH, 0));
        System.out.printf("%s - %d개\n", Rank.FOURTH.getDescription(), lottoStats.getOrDefault(Rank.FOURTH, 0));
        System.out.printf("%s - %d개\n", Rank.THIRD.getDescription(), lottoStats.getOrDefault(Rank.THIRD, 0));
        System.out.printf("%s - %d개\n", Rank.SECOND.getDescription(), lottoStats.getOrDefault(Rank.SECOND, 0));
        System.out.printf("%s - %d개\n", Rank.FIRST.getDescription(), lottoStats.getOrDefault(Rank.FIRST, 0));

        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
