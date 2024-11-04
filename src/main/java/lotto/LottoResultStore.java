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
                .forEach(lottoWinningRank -> winningResults.put(lottoWinningRank, INITIAL_RANK_VALUE));
    }

    public void store(int lottoNumberMatch, boolean isMatchBonusNumber) {
        LottoResultStructure lottoWinningRank = LottoResultStructure.valueOf(lottoNumberMatch, isMatchBonusNumber);
        winningResults.put(lottoWinningRank, winningResults.get(lottoWinningRank) + 1);
    }

    public Map<LottoResultStructure, Integer> getResults() {
        return Collections.unmodifiableMap(winningResults);
    }
}
