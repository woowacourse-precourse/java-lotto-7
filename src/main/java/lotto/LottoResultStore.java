package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import lotto.lottoMachine.utils.LottoResultStructure;

public class LottoResultStore {
    private static final int INITIAL_RANK_VALUE = 0;

    private final Map<LottoResultStructure, Integer> winningResults = new EnumMap<>(LottoResultStructure.class);

    public LottoResultStore() {
        initializeResults();
    }

    private void initializeResults() {
        Arrays.stream(LottoResultStructure.values())
                .forEach(rank -> winningResults.put(rank, INITIAL_RANK_VALUE));
    }

    public void store(int lottoNumberMatch, boolean isMatchBonusNumber) {
        LottoResultStructure rank = LottoResultStructure.valueOf(lottoNumberMatch, isMatchBonusNumber);
        winningResults.put(rank, winningResults.get(rank) + 1);
    }

    public Map<LottoResultStructure, Integer> getResults() {
        return Collections.unmodifiableMap(winningResults);
    }
}
