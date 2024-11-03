package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultChecker {

    public static Map<LottoRank, Integer> lottoResultFrom(PurchasedLottos purchasedLottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> lottoResult = new HashMap<>();
        List<Lotto> lottos = purchasedLottos.getLottos();

        for (Lotto lotto : lottos) {
            long matchingCount = lotto.matchingCountWith(winningLotto.getLotto());
            boolean isBonusNumberMatch = lotto.contains(winningLotto.getBonusNumber());
            LottoRank lottoRank = LottoRank.rankFrom(matchingCount, isBonusNumberMatch);
            if (isLottoRankNotNone(lottoRank)) {
                lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
            }
        }
        return lottoResult;
    }

    private static boolean isLottoRankNotNone(LottoRank lottoRank) {
        return lottoRank != LottoRank.NONE;
    }
}
