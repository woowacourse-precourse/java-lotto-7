package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public Map<Prize, Integer> countMatchesWith(WinningLotto winningLotto) {
        Map<Prize, Integer> prizeCounts = initializeRankCounts();

        lottos.forEach(lotto -> {
            Prize prize = winningLotto.determineRank(lotto);
            prizeCounts.put(prize, prizeCounts.get(prize) + 1);
        });

        return prizeCounts;
    }

    private Map<Prize, Integer> initializeRankCounts() {
        return Arrays.stream(Prize.values())
                .collect(Collectors.toMap(
                        rank -> rank,
                        rank -> 0,
                        (a, b) -> a,
                        () -> new EnumMap<>(Prize.class)
                ));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

}
