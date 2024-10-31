package lotto.view;

import lotto.domain.winning.WinningRank;
import lotto.domain.winning.WinningStatics;

import java.util.List;

public class OutputView {

    public void printLottoStatus(List<List<Integer>> Lottos) {
        System.out.println("\n" + Lottos.size() + "개를 구입했습니다.");
        for (List<Integer> lotto : Lottos) {
            System.out.println(lotto);
        }
    }

    public void printWinningStatics(WinningStatics winningStatics) {
        System.out.println("\n" + "당첨통계");
        System.out.println("---");

        for (WinningRank winningRank : winningStatics.getWinningStatics().keySet()) {
            if (winningRank.equals(winningRank.NONE)) {
                continue;
            }

            System.out.printf(winningRank.getWinningString(), winningStatics.getWinningCount(winningRank));
        }
    }
}
