package lotto.view;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.WinningStatus;

public class OutputView {

    public static void printLottoCount(List<Lotto> lottos, int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningStatistics(WinningStatus winningStatus) {
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + winningStatus.getPrizeCount("3개") + "개");
        System.out.println("4개 일치 (50,000원) - " + winningStatus.getPrizeCount("4개") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningStatus.getPrizeCount("5개") + "개");
        System.out.println(
            "5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningStatus.getPrizeCount("5개 + 보너스") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningStatus.getPrizeCount("6개") + "개");
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}
