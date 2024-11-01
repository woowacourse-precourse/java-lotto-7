package lotto.domain;

import lotto.constants.Ranking;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public EnumMap<Ranking, Integer> checkRanking(WinningLotto winningLotto) {
        EnumMap<Ranking, Integer> rankingMap = new EnumMap<>(Ranking.class);
        lottos.stream()
                .map(lotto -> lotto.checkRanking(winningLotto))
                .forEach(ranking -> rankingMap.merge(ranking, 1, Integer::sum));
        return rankingMap;
    }

    public List<List<Integer>> getAllLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getNumberValues)
                .collect(Collectors.toList());
    }

    public int getLottoCount(){
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
