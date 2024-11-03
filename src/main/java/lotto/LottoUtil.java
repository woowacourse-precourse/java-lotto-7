package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoUtil {

    public static Map<WinningKind, Integer> checkResult(List<Lotto> lottos, Host host) {
        Map<WinningKind, Integer> lottoResult = resultInit();
        return compareWithLottos(lottoResult, lottos, host);
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

    private static Map<WinningKind, Integer> resultInit() {
        Map<WinningKind, Integer> result = new HashMap<>();
        for (WinningKind winningKind : WinningKind.values()) {
            result.put(winningKind, 0);
        }
        return result;
    }

    private static Map<WinningKind, Integer> compareWithLottos(Map<WinningKind, Integer> lottoResult, List<Lotto> lottos, Host host) {
        for (Lotto lotto : lottos) {
            checkLotto(lottoResult, lotto, host);
        }
        return lottoResult;
    }

    private static void checkLotto(Map<WinningKind, Integer> lottoResult, Lotto lotto, Host host) {
        int matchCount = host.countResult(lotto);
        boolean bonus = false;
        if (host.isBonus(lotto)) {
            matchCount++;
            bonus = true;
        }
        if (matchCount < 3) return;

        WinningKind kind = WinningKind.getWinningKind(matchCount, bonus);
        lottoResult.put(kind, lottoResult.get(kind) + 1);
    }

}
