package lotto.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;

public class WinningResult {

    private static final int ZERO = 0;
    private final WinningNumbers winningNumbers;
    private final List<Lotto> lottos;

    public WinningResult(final WinningNumbers winningNumbers, final List<Lotto> lottos) {
        this.winningNumbers = winningNumbers;
        this.lottos = lottos;
    }

    public Map<LottoRank, Integer> getLottoRanks() {
        final Map<LottoRank, Integer> lottoRanks = initializeLottoRanks();
        for (Lotto lotto : lottos) {
            final LottoRank lottoRank = winningNumbers.matchWithLotto(lotto);
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
