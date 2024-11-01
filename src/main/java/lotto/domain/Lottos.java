package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public Map<Ranking, Integer> calculateLottoResult(WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::calculateRanking)
                .collect(Collectors.groupingBy(ranking -> ranking, Collectors.summingInt(r -> 1)));
    }
}
