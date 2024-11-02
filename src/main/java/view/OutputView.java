package view;

import domain.Lotto;
import domain.WinningLotto;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String PURCHASE_LOTTO_AMOUNT_MSG = "개를 구매했습니다.";
    private static final String WINNING_STATISTIC_MSG = "당첨 통계\n---\n";
    private static final String FIFTH_STATISTIC_MSG = "3개 일치 (5,000원) - ";
    private static final String FOURTH_STATISTIC_MSG = "4개 일치 (50,000원) - ";
    private static final String THIRD_STATISTIC_MSG = "5개 일치 (1,500,000원) - ";
    private static final String SECOND_STATISTIC_MSG = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String FIRST_STATISTIC_MSG = "6개 일치 (2,000,000,000원) - ";

    public void outputPurchaseLottoAmount(List<Lotto> lottos) {
        System.out.printf("%d" + PURCHASE_LOTTO_AMOUNT_MSG + "\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void outputWinningStatistics(Map<WinningLotto, Long> rankResult) {
        System.out.printf(WINNING_STATISTIC_MSG);
        System.out.printf(FIFTH_STATISTIC_MSG + "%d개%n", rankResult.getOrDefault(WinningLotto.FIFTH, 0L));
        System.out.printf(FOURTH_STATISTIC_MSG + "%d개%n", rankResult.getOrDefault(WinningLotto.FOURTH, 0L));
        System.out.printf(THIRD_STATISTIC_MSG + "%d개%n", rankResult.getOrDefault(WinningLotto.THIRD, 0L));
        System.out.printf(SECOND_STATISTIC_MSG + "%d개%n", rankResult.getOrDefault(WinningLotto.SECOND, 0L));
        System.out.printf(FIRST_STATISTIC_MSG + "%d개%n", rankResult.getOrDefault(WinningLotto.FIRST, 0L));
    }

    public void outputRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }

}
