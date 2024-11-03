package lotto.io;

import lotto.LottoPool;
import lotto.LottoRank;
import lotto.LottoStatistics;

public class OutputHandler {

    public void askLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showLottoQuantity(int quantity) {
        System.out.println();
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void showLottos(LottoPool lottoPool) {
        lottoPool.display();
    }

    public void askWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void askBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void showWinningStatistics(LottoStatistics lottoStatistics, int purchaseAmount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        displayWinningDetails(lottoStatistics);
        displayProfitMargin(lottoStatistics, purchaseAmount);
    }

    private void displayWinningDetails(LottoStatistics lottoStatistics) {
        for (LottoRank lottoRank : LottoRank.values()) {
            int winningCount = lottoStatistics.getWinningCount(lottoRank);
            String rankDescription = lottoRank.getDescription();

            System.out.println(rankDescription + " - " + winningCount + "개");
        }
    }

    private void displayProfitMargin(LottoStatistics lottoStatistics, int purchaseAmount) {
        int prizeAmount = lottoStatistics.calculatePrizeMoney();
        double profitMargin = lottoStatistics.calculateProfitMargin(purchaseAmount, prizeAmount);
        String fomattedProfitMargin = String.format("%.1f", profitMargin);

        System.out.println("총 수익률은 " + fomattedProfitMargin + "%입니다.");
    }
}
