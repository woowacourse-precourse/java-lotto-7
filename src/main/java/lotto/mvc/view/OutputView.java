package lotto.mvc.view;

import java.math.BigDecimal;
import java.util.Map;
import lotto.mvc.model.Lotto;
import lotto.mvc.model.LottoWinningAmount;
import lotto.util.LottoList;

public class OutputView {
    private static final String NUMBER_OF_LOTTO_PURCHASES = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MSG = "당첨 통계";
    private static final String WINNING_STATISTICS_DIVIDER = "---";
    private static final String WINNING_STATISTICS_FORMAT = "%s (%,d원) - %d개%n";
    private static final String Total_Return_FORMAT = "총 수익률은 %,.1f%%입니다.";

    public void showPurchaseDetails(LottoList lottoes, int count) {
        showNumberOfLottoPurchases(count);
        showLottoDetails(lottoes);
    }

    private void showNumberOfLottoPurchases(int count) {
        System.out.print(count);
        System.out.println(NUMBER_OF_LOTTO_PURCHASES);
    }

    private void showLottoDetails(LottoList lottoes) {
        for (Lotto lotto : lottoes.getBunchofLottoes()) {
            System.out.println(lotto);
        }
    }

    public void showWinningStatisticsDetails(Map<LottoWinningAmount, Integer> winningCounts) {
        showWinningStatisticsMsg();
        showWinningStatistics(winningCounts);
    }

    private void showWinningStatisticsMsg() {
        System.out.println(WINNING_STATISTICS_MSG);
        System.out.println(WINNING_STATISTICS_DIVIDER);
    }

    private void showWinningStatistics(Map<LottoWinningAmount, Integer> winningCounts) {
        LottoWinningAmount[] winningAmounts = LottoWinningAmount.values();

        for (LottoWinningAmount winningAmount : winningAmounts) {
            System.out.printf(WINNING_STATISTICS_FORMAT,
                    winningAmount.getDescription(),
                    winningAmount.getPrizeAmount(),
                    winningCounts.getOrDefault(winningAmount, 0));
        }
    }

    public void showTotalReturn(BigDecimal totalReturn) {
        System.out.printf(Total_Return_FORMAT, totalReturn.doubleValue());
    }
}
