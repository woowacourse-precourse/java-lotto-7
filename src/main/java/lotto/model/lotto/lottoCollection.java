package lotto.model.lotto;

import java.util.List;

public class lottoCollection {
    private final List<Lotto> lottos;

    public lottoCollection(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
