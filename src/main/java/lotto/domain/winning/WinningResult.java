package lotto.domain.winning;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.number.Lotto;
import lotto.domain.number.WinningNumber;

public class WinningResult {

    private static final int ZERO = 0;
    private final WinningNumber winningNumber;
    private final List<Lotto> lottos;

    public WinningResult(final WinningNumber winningNumber, final List<Lotto> lottos) {
        this.winningNumber = winningNumber;
        this.lottos = lottos;
    }

    public Map<LottoRank, Integer> getLottoRanks() {
        final Map<LottoRank, Integer> lottoRanks = initializeLottoRanks();
        for (Lotto lotto : lottos) {
            final LottoRank lottoRank = winningNumber.matchWithLotto(lotto);
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
