package lotto.view.output;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.PrizeResult;

public class OutputView {

    public void showTicket(int ticket) {
        System.out.print(ticket + "개를 구매했습니다.\n");
    }

    public void showLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void showProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    public void showPrizeResults(PrizeResult prizeResult) {
        System.out.println("당첨 통계\n---");
        for (Prize prize : Prize.values()) {
            if (prize == Prize.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n",
                        prize.getCount(),
                        prize.getPrize(),
                        prizeResult.getPrizeCount().get(prize));
            }
            if (prize != Prize.NONE && prize != Prize.SECOND) {
                System.out.printf("%d개 일치 (%,d원) - %d개\n",
                        prize.getCount(),
                        prize.getPrize(),
                        prizeResult.getPrizeCount().get(prize));
            }
        }
    }
}
