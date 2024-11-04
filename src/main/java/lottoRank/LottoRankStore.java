package lottoRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoRankStore {
    private final Map<LottoRankStructure, Integer> winningResults = new EnumMap<>(LottoRankStructure.class);
    private static final int INITIAL_RANK_VALUE = 0;

    public LottoRankStore() {
        initializeResults();
    }

    private void initializeResults() {
        Arrays.stream(LottoRankStructure.values())
                .forEach(rank -> winningResults.put(rank, INITIAL_RANK_VALUE));
    }

    public void store(int lottoNumberMatch, boolean isMatchBonusNumber) {
        LottoRankStructure rank = LottoRankStructure.valueOf(lottoNumberMatch, isMatchBonusNumber);
        winningResults.put(rank, winningResults.get(rank) + 1);
    }

    public Map<LottoRankStructure, Integer> getResults() {
        return Collections.unmodifiableMap(winningResults);
    }
}
