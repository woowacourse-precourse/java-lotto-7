package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottoGroup;

    public Lottos(List<Lotto> lottoGroup) {
        this.lottoGroup = lottoGroup;
    }

    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }
}
