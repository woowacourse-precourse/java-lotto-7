package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private Map<LottoRank, Integer> lottoResult;

    public WinningResult(final Lottos lottos, final WinningNumbersCombinations winningCombinations) {
        this.lottoResult = new EnumMap<>(LottoRank.class);
        generateLottoResult(lottos, winningCombinations);
    }

    private void generateLottoResult(final Lottos lottos, final WinningNumbersCombinations winningCombinations) {
        for (Lotto lotto : lottos.getLottos()) {
            LottoRank lottoRank = LottoRank.findLottoRank(
                    winningCombinations.compareWinningNumbers(lotto),
                    winningCombinations.compareBonusNumber(lotto)
            );
            countLottoRank(lottoRank);
        }
    }

    private void countLottoRank(final LottoRank lottoRank) {
        lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
    }
}
