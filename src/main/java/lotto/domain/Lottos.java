package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public LottoResult calculateResult(WinningLotto winningLotto) {
        List<LottoRank> lottoRanks = lottos.stream()
                .map(winningLotto::makeLottoRank)
                .toList();

        return new LottoResult(lottoRanks);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
