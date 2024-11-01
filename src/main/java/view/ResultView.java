package view;

import lotto.LottoRank;
import lotto.Lottos;

public class ResultView {

    private static final String PURCHASE_COMPLETE_PROMPT = "개를 구매했습니다.";

    public static void showLottoPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_COMPLETE_PROMPT);
    }

    public static void showCreatedLotto(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void showWinningStatistics(double revenueRate) {
        System.out.println("당첨 통계\n" + "-".repeat(3));
        System.out.println(LottoRank.winningStatus());
        System.out.println("총 수익률은 " + revenueRate + "%입니다.");
    }
}
