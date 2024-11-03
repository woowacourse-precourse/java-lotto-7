package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;

public class OutputView {
    private OutputView() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printPurchaseLottoMessage(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            printMessage(lotto.toString());
        }
    }

    public static void printResultMessage(Result result) {
        printMessage("당첨 통계");
        printMessage("---");
        for (Map.Entry<Rank, Integer> m : result.getWinningLottos().entrySet()) {
            printMessage(m.getKey().getDescription() + "-" + m.getValue() + "개");
        }
    }

    public static void printProfit(double profit) {
        printMessage("총 수익률은 " + profit + "%입니다.");
    }
}
