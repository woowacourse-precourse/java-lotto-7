package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.common.Winning;

public class OutputView {
    public void printLotto(int lottoCount, List<Lotto> lottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottoCount);
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.printf("[%d, %d, %d, %d, %d, %d]\n", numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), numbers.get(4), numbers.get(5));
        }
    }

    public void printResult(Map<Winning, Integer> winnings, double yield) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", winnings.getOrDefault(Winning.THREE, 0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", winnings.getOrDefault(Winning.FOUR, 0));
        System.out.printf("5개 일치 (1,500,000원) - 0개\n", winnings.getOrDefault(Winning.FIVE, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n", winnings.getOrDefault(Winning.FIVE_BONUS, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - 0개\n", winnings.getOrDefault(Winning.SIX, 0));
        System.out.println("총 수익률은" + yield + "%입니다.");
    }
}
