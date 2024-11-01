package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGroups {

    private final List<Lotto> lottos;

    private LottoGroups(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoGroups from(List<Lotto> lottos) {
        return new LottoGroups(lottos);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public LottoResult calculateLottoResult(WinningLotto winningLotto, Money initialMoney) {
        Map<Ranking, Integer> lottoResults = lottos.stream()
                .map(winningLotto::calculateRanking)
                .collect(Collectors.groupingBy(ranking -> ranking, Collectors.summingInt(r -> 1)));

        return LottoResult.of(lottoResults, initialMoney);
    }
}
