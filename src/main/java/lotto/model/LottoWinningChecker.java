package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinningChecker {

    private final Lottos lottos;
    private final WinningLotto winningLotto;

    private LottoWinningChecker(Lottos lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public static LottoWinningChecker of(Lottos lottos, WinningLotto winningLotto) {
        return new LottoWinningChecker(lottos, winningLotto);
    }

    public Map<LottoRank, Integer> getLottoWinningResult() {
        Map<LottoRank, Integer> lottoResult = new HashMap<>();
        List<Lotto> lottos = this.lottos.getLottos();

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
