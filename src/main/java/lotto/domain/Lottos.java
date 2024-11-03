package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottoGroup;
    private final int lottoQuantity;

    public Lottos(List<Lotto> lottoGroup) {
        this.lottoGroup = lottoGroup;
        this.lottoQuantity = lottoGroup.size();
    }

    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }

    public int getLottoQuantity() {
        return lottoQuantity;
    }
}
