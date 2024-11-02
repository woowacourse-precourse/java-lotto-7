package lotto.view;

import lotto.domain.earning.Earning;
import lotto.domain.winning.WinningRank;
import lotto.domain.winning.WinningStatics;

import java.util.List;

public class OutputView {

    private static final String AMOUNT_PURCHASE = "개를 구매했습니다.";
    private static final String WINNING_STATICS = "당첨 통계";
    private static final String DASH_LINE = "---";
    private static final String EARNING_RATIO = "총 수익률은 %.1f%%입니다.";

    public void printLottoStatus(List<List<Integer>> Lottos) {
        System.out.println();
        System.out.println(Lottos.size() + AMOUNT_PURCHASE);
        for (List<Integer> lotto : Lottos) {
            System.out.println(lotto);
        }
    }

    public void printWinningStatics(WinningStatics winningStatics) {
        System.out.println();
        System.out.println(WINNING_STATICS);
        System.out.println(DASH_LINE);

        for (WinningRank winningRank : winningStatics.getWinningStatics().keySet()) {
            if (winningRank.equals(winningRank.NONE)) {
                continue;
            }

            System.out.printf(winningRank.getWinningString(), winningStatics.getWinningCount(winningRank));
        }
    }

    public void printEarning(Earning earning) {
        System.out.printf(EARNING_RATIO, earning.getEarning());
    }
}
