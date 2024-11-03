package view;

import constants.Constants;
import lotto.Lottos;
import domain.statistics.WinningStatistics;

public class ResultView {

    private static final String PURCHASE_COMPLETE_PROMPT = "개를 구매했습니다.";

    public void showLottoPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_COMPLETE_PROMPT);
    }

    public void showCreatedLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public void showWinningStatistics(double revenueRate) {
        System.out.println("당첨 통계\n" + "-".repeat(3));
        System.out.println(WinningStatistics.winningStatus());
        System.out.println("총 수익률은 " + Constants.AMOUNT_NOTATION.format(revenueRate) + "%입니다.");
    }
}
