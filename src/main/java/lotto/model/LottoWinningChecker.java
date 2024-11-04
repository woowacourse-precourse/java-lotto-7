package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinningChecker {

    private final PurchasedLottos purchasedLottos;
    private final WinningLotto winningLotto;

    private LottoWinningChecker(PurchasedLottos purchasedLottos, WinningLotto winningLotto) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
    }

    public static LottoWinningChecker of(PurchasedLottos purchasedLottos, WinningLotto winningLotto) {
        return new LottoWinningChecker(purchasedLottos, winningLotto);
    }

    public Map<LottoRank, Integer> getLottoWinningResult() {
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
