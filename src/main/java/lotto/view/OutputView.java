package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.model.LottoWinningStatistics;
import lotto.model.Prize;

public class OutputView {
    public void printLottoTickets(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printStatistics(LottoWinningStatistics winningStatistics) {
        Map<Integer, Integer> matchCountMap = winningStatistics.calculateStatistics();
        double yield = winningStatistics.calculateYield();

        System.out.println();
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (%d원) - %d개\n", Prize.THREE.getPrizeAmount(), matchCountMap.get(3));
        System.out.printf("4개 일치 (%d원) - %d개\n", Prize.FOUR.getPrizeAmount(), matchCountMap.get(4));
        System.out.printf("5개 일치 (%d원) - %d개\n", Prize.FIVE.getPrizeAmount(), matchCountMap.get(5));
        System.out.printf("5개 일치, 보너스 볼 일치 (%d원) - %d개\n", Prize.BONUS.getPrizeAmount(), matchCountMap.get(7));
        System.out.printf("6개 일치 (%d원) - %d개\n", Prize.SIX.getPrizeAmount(), matchCountMap.get(6));

        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }

}