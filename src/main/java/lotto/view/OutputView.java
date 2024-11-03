package lotto.view;

import lotto.model.Lottos;
import lotto.model.WinningStatistic;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계\n---";

    public void showLottos(int count, Lottos lottos) {
        System.out.println("\n" + count + PURCHASE_MESSAGE);
        lottos.forEachLotto(System.out::println);
        System.out.println();
    }

    public void showWinningStatistics(WinningStatistic winningStatistic) {
        System.out.println("\n" + WINNING_STATISTICS_HEADER);
        System.out.println(winningStatistic);
    }
}
