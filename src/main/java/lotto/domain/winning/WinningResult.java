package lotto.domain.winning;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.number.Lotto;
import lotto.domain.number.Winning;

public class WinningResult {

    private static final int ZERO = 0;
    private final Winning winning;
    private final List<Lotto> lottos;

    public WinningResult(final Winning winning, final List<Lotto> lottos) {
        this.winning = winning;
        this.lottos = lottos;
    }

    public Map<LottoRank, Integer> getLottoRanks() {
        final Map<LottoRank, Integer> lottoRanks = initializeLottoRanks();
        for (Lotto lotto : lottos) {
            final LottoRank lottoRank = winning.matchWithLotto(lotto);
            final Integer count = lottoRanks.getOrDefault(lottoRank, ZERO);
            lottoRanks.put(lottoRank, count + 1);
        }
        lottoRanks.remove(LottoRank.RANK_NONE);
        return Collections.unmodifiableMap(lottoRanks);
    }

    private Map<LottoRank, Integer> initializeLottoRanks() {
        final Map<LottoRank, Integer> lottoRanks = new LinkedHashMap<>();
        final List<LottoRank> allLottoRankWithOutRankNone = LottoRank.findAllLottoRankWithOutRankNone();
        for (LottoRank lottoRank : allLottoRankWithOutRankNone) {
            lottoRanks.put(lottoRank, ZERO);
        }
        return lottoRanks;
    }

}
