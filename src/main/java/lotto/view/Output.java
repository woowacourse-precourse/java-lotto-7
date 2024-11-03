package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningKind;

import java.util.List;
import java.util.Map;

import static lotto.util.Util.cashFormat;
import static lotto.domain.WinningKind.MATCH_5_BONUS;

public class Output {

    public static void purchaseCount(int count) {
        print(count + "개 구매했습니다.");
    }

    public static void purchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) print(lotto.toString());
    }

    public static void resultStart() {
        print("당첨 통계\n---");
    }

    public static void wonResult(Map<WinningKind, Integer> lottoResult) {
        for (WinningKind kind : WinningKind.values()) {
            int count = lottoResult.get(kind);
            int prize = kind.getPrize();
            print(String.format(getFormat(kind), kind.getMatchCount(), cashFormat(prize), count));
        }
    }

    public static void yield(double yield) {
        print(String.format("총 수익률은 %.1f%%입니다.\n", yield));
    }

    private static String getFormat(WinningKind kind) {
        if (kind == MATCH_5_BONUS) {
            return "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
        }
        return "%d개 일치 (%s원) - %d개";
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
