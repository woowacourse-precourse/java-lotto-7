package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoUtil {

    public static Map<WinningKind, Integer> resultInit() {
        Map<WinningKind, Integer> result = new HashMap<>();
        for (WinningKind winningKind : WinningKind.values()) {
            result.put(winningKind, 0);
        }
        return result;
    }

    public static void checkLotto(Map<WinningKind, Integer> lottoResult, Lotto lotto, Host host) {
        int matchCount = host.countResult(lotto);
        boolean bonus = host.isBonus(lotto);

        if (matchCount < WinningKind.MATCH_3.getMatchCount()) return;

        WinningKind kind = WinningKind.getWinningKind(matchCount, bonus);
        lottoResult.put(kind, lottoResult.get(kind) + 1);
    }

    public static double getYield(Map<WinningKind, Integer> lottoResult, int purchaseAmount) {
        return (sumPrize(lottoResult) / (double) purchaseAmount) * 100;
    }

    private static double sumPrize(Map<WinningKind, Integer> lottoResult) {
        double sum = 0;
        for (WinningKind kind : WinningKind.values()) {
            sum += kind.getPrize() * lottoResult.get(kind);
        }
        return sum;
    }

}
