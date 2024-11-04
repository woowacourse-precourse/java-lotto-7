package lotto.view;

import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.model.LotteryStatistics;
import lotto.model.LottoPrize;

public class OutputView {
    private static final String OUTPUT_NUM_OF_LOTTO = "개를 구매했습니다.";
    private static final String OUTPUT_STATISTICS = "당첨 통계\n---";
    private static final String OUTPUT_STATISTICS_FORMAT = "%s - %d개";
    private static final String OUTPUT_RETURN_OF_INVESTMENT= "총 수익률은 %.1f%%입니다.";

    public void printNumberOfLotto(long size) {
        System.out.println(size + OUTPUT_NUM_OF_LOTTO);
    }

    public void printLotties(Lotties lotties) {
        for (Lotto lotto : lotties.getLottoTickets()) {
            printLotto(lotto);
        }
        System.out.println();
    }

    private void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }

    public void printStatistics(LotteryStatistics statistics) {
        System.out.println(OUTPUT_STATISTICS);
        for (LottoPrize prize: LottoPrize.values()) {
            if (prize == LottoPrize.NOTHING) {
                continue;
            }
            System.out.println(String.format(OUTPUT_STATISTICS_FORMAT, prize.info(), statistics.getWonCount(prize)));
        }
        System.out.println(String.format(OUTPUT_RETURN_OF_INVESTMENT, statistics.computeReturnOfInvestment()));
    }
}
