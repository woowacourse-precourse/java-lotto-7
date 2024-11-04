package lotto.domain.simulator;

import lotto.domain.model.Lotto;
import lotto.domain.model.WinningNumbers;
import lotto.domain.enums.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMatcher {
    private final List<Lotto> lottos;
    private final WinningNumbers winningNumbers;
    private final Map<Rank, Integer> rankCounts = new HashMap<>();

    public LottoMatcher(List<Lotto> lottos, WinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        initializeRankCounts();
        runMatch();
    }

    private void runMatch() {
        for (Lotto lotto : lottos) {
            int matchCount = calculateMatchCount(lotto.getNumbers(), winningNumbers.getWinningNumbers());
            boolean matchBonus = lotto.getNumbers().contains(winningNumbers.getBonusNumber());
            Rank rank = Rank.findRank(matchCount, matchBonus);
            addCount(rank);
        }
    }

    private void addCount(Rank rank) {
        if (rank != Rank.NONE) {
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
    }

    private int calculateMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
    }

    private void initializeRankCounts() {
        for (Rank rank : Rank.values()) {
            initialize(rank);
        }
    }

    private void initialize(Rank rank) {
        if (rank != Rank.NONE) {
            rankCounts.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts;
    }
}
