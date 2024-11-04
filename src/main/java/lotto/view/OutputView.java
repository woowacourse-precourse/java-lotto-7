package lotto.view;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.LottoStatus;
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

        for (LottoStatus status : LottoStatus.values()) {
            if (status != LottoStatus.NONE) {
                System.out.printf("%s (%,d원) - %d개%n",
                    status.getDescription(),
                    status.getPrize(),
                    winningStatus.getPrizeCount(status));
            }
        }
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}