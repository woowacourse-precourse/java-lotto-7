package lotto.domain.entity;

import lotto.domain.rank.LottoRank;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record Lottos(List<Lotto> lottos) implements Iterable<Lotto> {

    @Override
    public Iterator<Lotto> iterator() {
        return this.lottos.iterator();
    }

    public int size() {
        return this.lottos.size();
    }

    public Map<LottoRank, Long> calculateRankCounts() {
        return this.lottos.stream()
                .collect(Collectors.groupingBy(Lotto::getRank, Collectors.counting()));
    }

    public int calculateTotalPrize(final Map<LottoRank, Integer> rankPayouts) {
        return this.lottos.stream()
                .mapToInt(lotto -> rankPayouts.getOrDefault(lotto.getRank(), 0))
                .sum();
    }
}
