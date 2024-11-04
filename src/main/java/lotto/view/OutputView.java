package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class OutputView {

    public void printError(String message) {
        System.out.println(message);
    }

    public void printPurchaseCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void printWinningStatistics(LottoResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                printRankStatistics(rank, result.getCountForRank(rank));
            }
        }
    }

    private void printRankStatistics(Rank rank, int count) {
        System.out.printf("%s - %d개\n", rank.getDescription(), count);
    }

    public void printReturnRate(double returnRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnRate);
    }
}