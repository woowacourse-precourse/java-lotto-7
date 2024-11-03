package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.wrapper.BonusNumber;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Rank, Integer> countMatchesWith(WinningLotto winningLotto) {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottos) {
            int matchCount = matchCount(lotto, winningLotto.getWinningNumbers());
            boolean bonusMatch = lotto.contains(winningLotto.getBonusNumber().getNumber());
            Rank rank = Rank.valueOf(matchCount, bonusMatch);

            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }

        for (Rank rank : Rank.values()) {
            rankCounts.putIfAbsent(rank, 0);
        }

        return rankCounts;
    }

    private int matchCount(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto::contains)
                .count();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
