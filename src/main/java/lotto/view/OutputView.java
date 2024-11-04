package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.model.LottoWinningStatics;

public class OutputView {
    public void printLottoTickets(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printStatistics(LottoWinningStatics winningStatics) {
        Map<Integer, Integer> matchCountMap = winningStatics.calculateStatistics();
        double yield = winningStatics.calculateYield();

        System.out.println();
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", matchCountMap.get(3));
        System.out.printf("4개 일치 (50,000원) - %d개\n", matchCountMap.get(4));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", matchCountMap.get(5));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", matchCountMap.get(7));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", matchCountMap.get(6));

        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}