package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankCalculator {
    public List<Integer> compareLottos(List<Lotto> lottos, Lotto winningNumbers) {
        return lottos.stream()
                .map(lotto -> compareSingleLotto(lotto,winningNumbers))
                .toList();
    }

    private int compareSingleLotto(Lotto userLotto, Lotto winningNumbers) {
        return (int) userLotto.getNumbers().stream().filter(winningNumbers.getNumbers()::contains).count();
    }

    public Rank determineRank(int matchCount, boolean isBonusContain) {
        return Rank.valueOf(matchCount, isBonusContain);
    }

    public Map<Rank, Integer> finalRank(List<Rank> ranking){
        Map<Rank,Integer> ranks = new HashMap<>();

        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }

        for (Rank rank : ranking) {
            ranks.put(rank, ranks.get(rank) + 1);
        }

        return ranks;
    }
}
