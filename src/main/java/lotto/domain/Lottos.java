package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;
    private final int amount;

    public Lottos(List<Lotto> lottos, int amount) {
        this.lottos = lottos;
        this.amount = amount;
    }

    public List<Rank> getRanks(Winning winning) {
        return lottos.stream()
                .map(lotto -> lotto.getRank(winning.getNumbers(), winning.getBonus()))
                .filter(rank -> rank != Rank.NOTHING)
                .sorted(Comparator.comparingInt(Rank::getMatchedCount))
                .toList();
    }

    public int getAmount() {
        return amount;
    }

    public int getQuantity() {
        return lottos.size();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
