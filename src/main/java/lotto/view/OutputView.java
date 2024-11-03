package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningPrize;
import lotto.domain.WinningResult;

public class OutputView {

    public static void printLotto(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinning(WinningResult result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WinningPrize prize : WinningPrize.values()) {
            if (WinningPrize.NONE == prize) {
                continue;
            }
            System.out.println(prize + " - " + result.get(prize) + "개");
        }
        System.out.println("총 수익률은 " + result.getTotalRate() + "%입니다.");
    }
}
