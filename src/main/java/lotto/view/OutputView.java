package lotto.view;

import lotto.message.WinningNumMessage;
import lotto.model.Lotto;

import java.util.List;

public class OutputView {

    public void printLottoCount(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printWinningStatistics(int[] matchCounts) {
        System.out.println("당첨 통계\n---");
        System.out.printf(WinningNumMessage.MATCHES_3_WINNING.getMessage(), matchCounts[0]);
        System.out.printf(WinningNumMessage.MATCHES_4_WINNING.getMessage(), matchCounts[1]);
        System.out.printf(WinningNumMessage.MATCHES_5_WINNING.getMessage(), matchCounts[2]);
        System.out.printf(WinningNumMessage.MATCHES_BONUS_WINNING.getMessage(), matchCounts[3]);
        System.out.printf(WinningNumMessage.MATCHES_6_WINNING.getMessage(), matchCounts[4]);
    }

    public void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}
