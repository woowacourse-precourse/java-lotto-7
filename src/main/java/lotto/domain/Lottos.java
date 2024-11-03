package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Rank, Integer> countMatchesWith(WinningLotto winningLotto) {
        Map<Rank, Integer> rankCounts = initializeRankCounts();

        lottos.forEach(lotto -> {
            Rank rank = winningLotto.determineRank(lotto);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        });

        return rankCounts;
    }

    private Map<Rank, Integer> initializeRankCounts() {
        return Arrays.stream(Rank.values())
                .collect(Collectors.toMap(
                        rank -> rank,
                        rank -> 0,
                        (a, b) -> a,
                        () -> new EnumMap<>(Rank.class)
                ));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

}
