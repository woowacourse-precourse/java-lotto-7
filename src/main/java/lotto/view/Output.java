package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;

public class Output {
    private static final String BUY_LOTTO = "%n%d개를 구매했습니다.%n";
    private static final String RESULT_TITLE = "\n당첨 통계\n---";
    private static final String RESULT_WINNING_BASIC = "%d개 일치 (%s원) - %d개%n";
    private static final String RESULT_WINNING_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n";
    private static final String RESULT_REVENUE = "총 수익률은 %.1f%%입니다.";

    public void printPayResult(List<Lotto> lottos) {
        System.out.printf(BUY_LOTTO, lottos.size());

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void lottoResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public void lottoResultWinning(Rank rank, int count) {
        if (rank == Rank.SECOND) {
            System.out.printf(RESULT_WINNING_BONUS, rank.getGoal(), rank.getStrPrize(), count);
            return;
        }
        System.out.printf(RESULT_WINNING_BASIC, rank.getGoal(), rank.getStrPrize(), count);
    }

    public void lottoResultTotalRevenue(double revenue) {
        System.out.printf(RESULT_REVENUE, revenue);
    }
}
