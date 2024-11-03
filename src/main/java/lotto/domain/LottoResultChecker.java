package lotto.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LottoResultChecker {
    private final LottoRaffle lottoRaffle;
    private final List<Lotto> lottos;
    private final Map<Rank, Integer> rankCount = new HashMap<>();

    public LottoResultChecker(LottoRaffle lottoRaffle, List<Lotto> lotto) {
        this.lottoRaffle = lottoRaffle;
        this.lottos = lotto;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public int findMatchCount(Lotto lotto) {
        HashSet<Integer> winningNumbers = new HashSet<>(lottoRaffle.getWinningNumbers());
        HashSet<Integer> lottoNumbers = new HashSet<>(lotto.getNumbers());
        lottoNumbers.retainAll(winningNumbers);
        return lottoNumbers.size();
    }

    public boolean findBonusBallMatch(Lotto lotto) {
        int bonusBall = lottoRaffle.getBonusNumber();
        return lotto.getNumbers().stream().anyMatch(number -> number == bonusBall);
    }

    public Map<Rank, Integer> findRank() {
        for (Lotto lotto : lottos) {
            Rank rank = Rank.findRank(findMatchCount(lotto), findBonusBallMatch(lotto));
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }

}
