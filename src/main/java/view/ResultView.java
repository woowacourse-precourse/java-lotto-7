package view;

import lotto.Lottos;
import lotto.WinningRank;

public class ResultView {

    private static final String PURCHASE_COMPLETE_PROMPT = "개를 구매했습니다.";

    public static void showLottoPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_COMPLETE_PROMPT);
    }

    public static void showCreatedLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void showWinningStatistics(double revenueRate) {
        System.out.println("당첨 통계\n" + "-".repeat(3));
        System.out.println(WinningRank.winningStatus());
        System.out.println("총 수익률은 " + revenueRate + "%입니다.");
    }
}
