package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Rank, Long> countMatching(WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::findRank)
                .collect(Collectors.groupingBy(match -> match, Collectors.counting()));
    }

    public int size() {
        return lottos.size();
    }
}
