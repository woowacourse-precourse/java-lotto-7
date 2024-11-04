package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;

public class Output {
    public void printPayResult(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

    }

    public void lottoResultTitle() {
        System.out.println("당첨 통계\n---");
    }

    public void lottoResultWinning(Rank rank, int count) {
        System.out.printf("%d개 일치 (%s원) - %d개", rank.getGoal(), rank.getStrPrize(), count);
    }

    public void lottoResultTotalRevenue(double revenue) {
        System.out.printf("총 수익률은 %f%입니다.", revenue);
    }

}
