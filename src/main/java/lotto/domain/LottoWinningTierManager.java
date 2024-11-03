package lotto.domain;

import java.util.*;

public class LottoWinningTierManager {
    private final Map<LottoWinningTier, Integer> lottoWinningTiers;

    public LottoWinningTierManager() {
        lottoWinningTiers = new HashMap<>(Map.of(
                LottoWinningTier.NONE, 0,
                LottoWinningTier.MATCH_THREE, 0,
                LottoWinningTier.MATCH_FOUR, 0,
                LottoWinningTier.MATCH_FIVE, 0,
                LottoWinningTier.MATCH_FIVE_WITH_BONUS, 0,
                LottoWinningTier.MATCH_SIX, 0
        ));
    }

    public Map<LottoWinningTier, Integer> getLottoWinningTiers() {
        return lottoWinningTiers;
    }

    public int calculateTotalPrize() {
        return lottoWinningTiers.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public void increaseLottoWinningTier(int matchCount, boolean isBonusNumber) {
        if (matchCount == 5 && isBonusNumber) {
            checkLottoWinningTier(matchCount, true);
            return;
        }
        checkLottoWinningTier(matchCount, isBonusNumber);
    }
    public void checkLottoWinningTier (int matchCount, boolean isBonusNumber) {
        lottoWinningTiers.put(
                LottoWinningTier.getMatchCountTier(matchCount, isBonusNumber),
                lottoWinningTiers.get(LottoWinningTier.getMatchCountTier(matchCount, isBonusNumber)) + 1);
    }
}
