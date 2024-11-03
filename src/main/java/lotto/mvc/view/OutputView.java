package lotto.mvc.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.mvc.model.Lotto;
import lotto.mvc.model.LottoWinningAmount;

public class OutputView {
    public void showNumberOfLottoPurchases(int count) {
        System.out.print(count);
        System.out.println("개를 구매했습니다.");
    }

    public void showLottoDetails(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void showWinningStatisticsMsg() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void showWinningStatistics(Map<LottoWinningAmount, Integer> winningCounts) {
        LottoWinningAmount[] winningAmounts = LottoWinningAmount.values();

        for (LottoWinningAmount winningAmount : winningAmounts) {
            System.out.printf("%s (%,d원) - %d개%n",
                    winningAmount.getDescription(),
                    winningAmount.getAmount(),
                    winningCounts.getOrDefault(winningAmount, 0));
        }
    }

    public void showTotalReturn(BigDecimal totalReturn) {
        System.out.printf("총 수익률은 %s%%입니다.", totalReturn.toPlainString());
    }
}
