package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoRankManager {
    private final Map<LottoRank, Integer> rankedPrizeCounts;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public LottoRankManager() {
        rankedPrizeCounts = new EnumMap<>(LottoRank.class);
        initializeRankedPrizeCounts();
    }

    private void initializeRankedPrizeCounts() {
        for (LottoRank rank : LottoRank.values()) {
            rankedPrizeCounts.put(rank, 0);
        }
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Map<LottoRank, Integer> evaluateLottoRanks(List<Lotto> lottoList) {
        lottoList.forEach(this::assignLottoRank);
        return rankedPrizeCounts;
    }

    private void assignLottoRank(Lotto lotto) {
        lotto.updateMatchCount(winningNumbers);
        lotto.updateContainsBonusNumber(bonusNumber);

        LottoRank rank = LottoRank.fromMatchCount(lotto.getMatchCount(), lotto.isContainsBonusNumber());
        if (rank != null) {
            rankedPrizeCounts.merge(rank, 1, Integer::sum);
        }
    }
}
